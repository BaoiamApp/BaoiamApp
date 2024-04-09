package com.baoiaminnovations.baoiamapp.profileFeature

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.components.PasswordTextField
import com.baoiaminnovations.baoiamapp.ui.theme.Button1Preview
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient2

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun EditProfile() {



    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
            val text = null
            val (image , fullname , phone , email , password2 , button) = createRefs()
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

        Box(modifier = Modifier.constrainAs(image) {
            top.linkTo(parent.top, margin = 30.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Image(painter = painterResource(id = R.drawable.ic_android_black_24dp)
                , contentDescription = ""
                , modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = Color.Yellow, CircleShape)
                    .background(Color.Gray)
                    )
            Image(painter = painterResource(
                id = R.drawable.baseline_photo_camera_24)
                ,contentDescription = ""
            , modifier = Modifier
                    .padding(top = 75.dp, start = 75.dp)
                    .size(25.dp)
                    .clip(CircleShape)
                    .clickable {  }   // Navigate to camera and album popup
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                LinearGradient, LinearGradient2
                            )
                        )
                    ))

        }

        Column(modifier = Modifier
            .fillMaxWidth().background(Color.White)
            .constrainAs(fullname) {
                top.linkTo(image.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            Text(text = "Full name"
                , modifier = Modifier.padding(start = 30.dp)
                    , fontSize = 17.sp, color = Color.Black)

            BasicTextField(text = username
                ,id = R.string.enter_your_full_name)
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(email) {
                top.linkTo(phone.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            Text(text = "Email"
                , modifier = Modifier.padding(start = 30.dp)
                , fontSize = 17.sp, color = Color.Black)

            BasicTextField(text = emailadd, id = R.string.emailaddress)
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(phone) {
                top.linkTo(fullname.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            Text(text = "Phone"
                , modifier = Modifier.padding(start = 30.dp)
                , fontSize = 17.sp, color = Color.Black)

            /* OutlinedTextField(
                 value = text.value,
                 onValueChange = { text.value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                label = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
            )*/
        }



        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(password2) {
                top.linkTo(email.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            Text(text = "Password"
                , modifier = Modifier.padding(start = 30.dp)
                , fontSize = 17.sp, color = Color.Black)

            PasswordTextField(password = password, visibility = visibility, id = R.string.password)
        }

        Column(modifier = Modifier
            .width(160.dp)
            .height(44.dp)
            .constrainAs(button) {
                top.linkTo(password2.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }){

          Button1Preview(text = stringResource(id = R.string.btn_save)

              , onClick = { /*TODO*/ }  // Save the information's and navigate to profile screen
              ,modifier =Modifier
                  .align(CenterHorizontally)
                  .fillMaxSize()
                  )
        }

        
    }
}