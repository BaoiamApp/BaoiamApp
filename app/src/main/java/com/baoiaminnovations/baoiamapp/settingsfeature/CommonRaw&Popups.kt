package com.baoiaminnovations.baoiamapp.settingsfeature

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.OtpTextFields
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient2
import com.baoiaminnovations.baoiamapp.ui.theme.softOrange
import com.baoiaminnovations.baoiamapp.ui.theme.softWhite


@Composable
fun CommonRaw(
    int: Painter,
    text: String,
    text2: String,
    onClick:() -> Unit,
    )
{


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (image, _text, text0) = createRefs()

            Image(
                int,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .constrainAs(image) {
                        start.linkTo(parent.start, margin = 20.dp)
                    }

            )

            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(_text){
                        start.linkTo(image.end, margin = 20.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }

            )
            Text(
                text = text2,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = softOrange,
                modifier = Modifier
                    .clickable { onClick() }
                    .constrainAs(text0) {
                        end.linkTo(parent.end, margin = 20.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }

            )
        }
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileNoPopup(int: Painter, cancel:() -> Unit, confirm: ()-> Unit ) {

        Column(horizontalAlignment = CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
        ) {
            Image(
                int,
                contentDescription = "",
                modifier = Modifier.padding(top = 30.dp)

            )

            Text(
                text = "Enter mobile number to link \nyour account",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 30.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            val name = remember {mutableStateOf("")}
            val maxcharacter = 10
            OutlinedTextField(
                value = name.value,
                onValueChange ={
                    if (it.length<=maxcharacter){
                        name.value= it
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                placeholder = {
                    Text(text = "Enter your phone number", fontSize = 14.sp)
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = softWhite),
                modifier = Modifier
                    .border(width = 2.dp, color = softWhite)
                    .height(55.dp)
                    .width(250.dp)

            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { confirm() }, modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            LinearGradient,
                            LinearGradient2
                        )
                    ), shape = RoundedCornerShape(10.dp)
                )
                .width(250.dp)
                .height(45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)


            ) {
                Text(text = "Confirm", fontSize = 18.sp, color = Color.White)
            }

            TextButton(
                onClick = { cancel()},

                ) {
                Text(
                    text = "Cancel",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        }
    }




@Composable
fun SuccessfullyPopup(GoBack:() -> Unit) {


    Column(horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        /*Image(
            painter = painterResource(id = R.drawable.paytm_logo),
            contentDescription = "",
            modifier = Modifier.padding(top = 30.dp)

        )*/
        Image(
            painter = painterResource(id = R.drawable.success_icon),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 20.dp)
                .size(90.dp)
        )

        Text(
            text = "Your account have been\nsuccessfully linked",
            textAlign = TextAlign.Center,
            modifier = Modifier,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {GoBack()}, modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LinearGradient,
                        LinearGradient2
                    )
                ), shape = RoundedCornerShape(10.dp)
            )
            .width(250.dp)
            .height(45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)


        ) {
            Text(text = "Go Back", fontSize = 18.sp, color = Color.White)
        }
    }
}



@Composable
fun OTPPopup(cancel:() -> Unit, confirm: ()-> Unit,resend: ()-> Unit) {


    var otp1 = remember {
        mutableStateOf("")
    }
    var otp2 = remember {
        mutableStateOf("")
    }
    var otp3 = remember {
        mutableStateOf("")
    }
    var otp4 = remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .background(
                Color.White,
                shape = RoundedCornerShape( 15.dp)
            )
    ) {
        Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.x_square),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 15.dp, end = 15.dp)
                    .clickable {cancel()}
            )
        }

        Text(
            text = "Enter OTP sent to number- \n7697345623",
            textAlign = TextAlign.Center,
            modifier = Modifier,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
        ) {
            OtpTextFields(number = otp1, labelTextId = R.string.default_otp)
            Spacer(modifier = Modifier.width(20.dp))
            OtpTextFields(number = otp2, labelTextId = R.string.default_otp)
            Spacer(modifier = Modifier.width(20.dp))
            OtpTextFields(number = otp3, labelTextId = R.string.default_otp)
            Spacer(modifier = Modifier.width(20.dp))
            OtpTextFields(number = otp4, labelTextId = R.string.default_otp)

        }

        Spacer(modifier = Modifier.height(15.dp))


        Button(onClick = {confirm()}, modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LinearGradient,
                        LinearGradient2
                    )
                ), shape = RoundedCornerShape(10.dp)
            )
            .width(250.dp)
            .height(45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)


        ) {
            Text(text = "Confirm", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = { resend() },
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 2.dp, color = softOrange),
            modifier = Modifier
                .width(250.dp)
                .height(45.dp)


        ) {
            Text(
                text = "Resend OTP",
                fontSize = 18.sp,
                style = TextStyle(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            LinearGradient,
                            LinearGradient2
                        )
                    )
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(215.dp)
                .height(20.dp)

        ) {
            Text(
                text = "By continuing, you are agreeing to our",
                fontWeight = FontWeight.Normal,
                fontSize = 11.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(130.dp)
                .height(20.dp)


        ){
            Text(
                text = "T&C",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {  }
            )

            Text(
                text = " and ",
                fontWeight = FontWeight.Normal,
                fontSize = 11.sp,
                color = Color.Black,
            )

            Text(
                text = "Privacy Policy",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {  }
            )
        }
    }
}