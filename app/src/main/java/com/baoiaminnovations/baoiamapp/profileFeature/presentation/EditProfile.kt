package com.baoiaminnovations.baoiamapp.profileFeature.presentation

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.PasswordTextField
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.common.presentation.Screens
import com.baoiaminnovations.baoiamapp.common.presentation.components.ProgressDialogBox
import com.baoiaminnovations.baoiamapp.ui.theme.Button1Preview


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun EditProfile(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {

    var isPopupVisible by remember { mutableStateOf(false) }
    //var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    //var context = LocalContext.current


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val (image, fullname, phone, email, password2, button, popup) = createRefs()

        var username = remember {
            mutableStateOf("")
        }
        var phoneNo = remember {
            mutableStateOf("")
        }
        var emailadd = remember {
            mutableStateOf("")
        }
        var password = remember {
            mutableStateOf("")
        }
        var visibility = remember {
            mutableStateOf(true)
        }
        val dpUrl = remember {
            mutableStateOf("")
        }
        val showCircularProgressBar = remember { mutableStateOf(false) }

        if (showCircularProgressBar.value)
            ProgressDialogBox(message = mutableStateOf(stringResource(id = R.string.updatingProfile)))

        val result = viewModel.resultOfUpdatingUserData.observeAsState().value
        if (result == Constants.SUCCESS) {
            viewModel.getUserName()
            showCircularProgressBar.value = false
            Toast.makeText(
                activity,
                "Profile successfully updated",
                Toast.LENGTH_SHORT
            ).show()
            navHostController.popBackStack()
            navHostController.navigate(Screens.ProfileScreen.route)
        } else if (result == Constants.FAILURE) {
            Toast.makeText(
                activity,
                "Failed to update. Please try again",
                Toast.LENGTH_SHORT
            ).show()
            showCircularProgressBar.value = false
        }

        var imageUri = remember { mutableStateOf<Uri>(Uri.EMPTY) }
        // Code Snippet For profile image
        viewModel.getDataOfUser()
        viewModel.getDataOfUser.observe(activity) {
            username.value = it.name
            emailadd.value = it.emailOrPhoneNumber
            phoneNo.value = it.phoneNumber
            dpUrl.value = it.imageUrl
        }


        Box(modifier = Modifier.constrainAs(image) {
            top.linkTo(parent.top, margin = 30.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            if (imageUri.value == Uri.EMPTY) {
                AsyncImage(
                    model = dpUrl.value,
                    contentDescription = "Empty profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp)
                        .clickable {
                            isPopupVisible = true
                        }
                        .border(
                            3.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = CircleShape
                        )
                )
            } else {
                AsyncImage(
                    model = imageUri.value,
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentScale = ContentScale.Crop
                )
            }

            /*        Image(painter = painterResource(
                        id = R.drawable.group_616
                    ), contentDescription = "", modifier = Modifier
                        .padding(top = 70.dp, start = 70.dp)
                        .size(25.dp)
                        .clip(CircleShape)
                        .clickable {
                            isPopupVisible = true
                        }   // Navigate to camera and album popup
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    LinearGradient, LinearGradient2
                                )
                            )
                        ))*/

        }
        // Code Snippet For Text field fullname

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .constrainAs(fullname) {
                top.linkTo(image.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(
                text = "Full name",
                modifier = Modifier.padding(start = 30.dp),
                fontSize = 17.sp,
                color = Color.Black
            )

            BasicTextField(
                text = username, id = R.string.enterYourFullName
            )
        }

        // Code Snippet For Text field email

        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(email) {
                top.linkTo(phone.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(
                text = "Email",
                modifier = Modifier.padding(start = 30.dp),
                fontSize = 17.sp,
                color = Color.Black
            )


            BasicTextField(text = emailadd, id = R.string.emailAddress)
        }

        // Code Snippet For Text field phone

        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(phone) {
                top.linkTo(fullname.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(
                text = "Phone",
                modifier = Modifier.padding(start = 30.dp),
                fontSize = 17.sp,
                color = Color.Black
            )

            // needs to implement dropdown

            OutlinedTextField(
                value = phoneNo.value,
                onValueChange = { phoneNo.value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.drop_down),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 40.dp)
                            .clickable { })

                    Image(
                        painter = painterResource(id = R.drawable.india_logo),
                        contentDescription = ""
                    )

                },
                label = {
                    Text(
                        text = stringResource(R.string.enterYourPhoneNo),
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
            )
        }


        // Code Snippet For Text field password

        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(password2) {
                top.linkTo(email.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(
                text = "Password",
                modifier = Modifier.padding(start = 30.dp),
                fontSize = 17.sp,
                color = Color.Black
            )

            PasswordTextField(
                password = password,
                visibility = visibility,
                id = R.string.password
            )
        }

        // Code Snippet For Button save

        Column(modifier = Modifier
            .width(160.dp)
            .height(44.dp)
            .constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }) {

            Button1Preview(
                text = stringResource(id = R.string.save),
                onClick = {
                    showCircularProgressBar.value = true
                    var userModel = userModel(
                        name = username.value,
                        phoneNumber = phoneNo.value,
                        emailOrPhoneNumber = emailadd.value
                    )
                    viewModel.updateTheUserData(userModel)
                }  // Save the information's and navigate to profile screen
                ,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .fillMaxSize()
            )

        }

        // Code Snippet For Popup Window Initialization

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .constrainAs(popup) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            if (isPopupVisible) {
                ModalBottomSheet(onDismissRequest = { isPopupVisible = false }) {
                    PopUpWindow(navHostController, imageUri, viewModel, activity)
                }
            }
        }
    }
}











