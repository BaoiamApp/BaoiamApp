package com.baoiaminnovations.baoiamapp.profileFeature.presentation

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.common.presentation.components.ProgressDialogBox
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects


@Composable
fun PopUpWindow(
    navHostController: NavHostController,
    imageUri: MutableState<Uri>,
    viewModel: AppViewModel,
    activity: MainActivity
) {

    var context = LocalContext.current

    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.applicationContext.packageName + ".provider", file
    )

    val showProgressBar = remember { mutableStateOf(false) }

    //  var imageUri by remember { mutableStateOf<Uri>(Uri.EMPTY) }

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    val camlauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) {
        showProgressBar.value = true
        imageUri.value = uri
        val extension =
            MimeTypeMap.getSingleton()
                .getExtensionFromMimeType(activity.contentResolver.getType(uri))
                .toString()
        viewModel.uploadingProfilePicture(uri, extension, activity,showProgressBar)
    }


    val photolauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri.value = uri!!
            val extension =
                MimeTypeMap.getSingleton()
                    .getExtensionFromMimeType(activity.contentResolver.getType(uri))
                    .toString()
            viewModel.uploadingProfilePicture(uri, extension, activity,showProgressBar)
            viewModel.resultOfIUploadingProfilePicture.observe(activity) {
                if (it == Constants.SUCCESS) {
                    Toast.makeText(activity, "Picture uploaded successfully", Toast.LENGTH_SHORT)
                        .show()
                } else if (it == Constants.FAILURE) {
                    Toast.makeText(activity, "Failed to upload the picture", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    /*  imageUri?.let {
          if (Build.VERSION.SDK_INT < 28) {
              bitmap = MediaStore.Images
                  .Media.getBitmap(context.contentResolver, it)
          } else {
              val source = ImageDecoder.createSource(context.contentResolver, it)
              bitmap = ImageDecoder.decodeBitmap(source)
          }
          bitmap?.let { btm ->
              Image(bitmap = btm.asImageBitmap(), contentDescription = null)
          }

      }*/

    val permission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {
            if (it) {
                camlauncher.launch(uri)
            } else {
                Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        })



    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
    ) {
        val (text, camera, photos, delete, txtcamera, txtphoto) = createRefs()


        // Code Snippet For Text "profile photo"
        if (showProgressBar.value) {
            ProgressDialogBox(message = mutableStateOf(stringResource(id = R.string.updatingProfilePicture)))
        }
        Text(
            text = "Profile Photo",
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }, fontSize = 18.sp, color = Color.Black
        )

        // Code Snippet For Image "Camera"

        Box(modifier = Modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable {

            }    // Navigate to camera
            .constrainAs(camera) {
                top.linkTo(text.bottom, margin = 20.dp)
                start.linkTo(parent.start, margin = 20.dp)
            }) {
            Image(
                painter = painterResource(id = R.drawable.camera_app),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Center)
                    .clickable {
                        if (ContextCompat.checkSelfPermission(
                                context,
                                android.Manifest.permission.CAMERA
                            ) == PackageManager.PERMISSION_GRANTED
                        ) {
                            camlauncher.launch(uri)
                        } else {
                            permission.launch(android.Manifest.permission.CAMERA)
                        }
                    }
            )
        }

        // Code Snippet For Image "Photos"

        Box(modifier = Modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable {
                photolauncher.launch("image/*")
            }     // Navigate to photos
            .constrainAs(photos) {
                top.linkTo(camera.top)
                bottom.linkTo(camera.bottom)
                start.linkTo(camera.end, margin = 30.dp)
            }) {
            Image(
                painter = painterResource(id = R.drawable.photos),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Center)
            )
        }

        // Code Snippet For Image "Delete"

        AsyncImage(model = imageUri.value,
            contentDescription = "",
            modifier = Modifier
                .size(30.dp)
                .clickable { }     // Navigate to
                .constrainAs(delete) {
                    top.linkTo(parent.top, margin = 20.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                }
        )

        // Code Snippet For Text "Camera"

        Box(modifier = Modifier
            .width(80.dp)
            .height(20.dp)
            .constrainAs(txtcamera) {
                top.linkTo(camera.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 20.dp)
            }) {
            Text(
                text = "Camera",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.align(Center)
            )
        }

        // Code Snippet For Text "albums"

        Box(modifier = Modifier
            .width(80.dp)
            .height(20.dp)
            .constrainAs(txtphoto) {
                top.linkTo(txtcamera.top)
                bottom.linkTo(txtcamera.bottom)
                start.linkTo(txtcamera.end, margin = 30.dp)
            }) {
            Text(
                text = "Albums",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.align(Center)
            )
        }

    }
}

fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName, /* prefix */
        ".jpg", /* suffix */
        externalCacheDir      /* directory */
    )
    return image
}

