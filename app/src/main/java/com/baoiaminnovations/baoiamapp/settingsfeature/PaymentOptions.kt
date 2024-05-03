package com.baoiaminnovations.baoiamapp.settingsfeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.ui.theme.softOrange

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PaymentOptions() {

        var isPaytmDialog by remember { mutableStateOf(false) }
        var isAmazonDialog by remember { mutableStateOf(false) }
        var isMobiKwikDialog by remember { mutableStateOf(false) }
        var isOTPok by remember { mutableStateOf(false) }
        var isConfirmClicked by remember { mutableStateOf(false) }

    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            HeadingText(text = "Saved Cards")

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color.White)
            ){
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                    val (
                        image, image2, _text, text0,
                        username, cardno, addcardtxt
                    ) = createRefs()
                
                    Image(
                        painter = painterResource(id = R.drawable.outlined_mastercard),
                        contentDescription = "",
                        modifier = Modifier
                            .constrainAs(image) {
                                start.linkTo(parent.start, margin = 20.dp)
                                top.linkTo(parent.top, margin = 30.dp)
                        }
                    )

                    Text(
                        text = "Master Card",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .constrainAs(_text){
                                start.linkTo(image.end, margin = 20.dp)
                                top.linkTo(parent.top, margin = 20.dp)

                            }
                    )

                    Text(
                        text = "Remove",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = softOrange,
                        modifier = Modifier
                            .clickable { }
                            .constrainAs(text0) {
                                end.linkTo(parent.end, margin = 20.dp)
                                top.linkTo(parent.top, margin = 40.dp)

                            }
                    )
                    Text(
                        text = "User Name",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .constrainAs(username){
                                start.linkTo(image.end, margin = 20.dp)
                                top.linkTo(parent.top, margin = 42.dp)

                            }
                    )
                    Text(
                        text = "XXXX XXXX 9933",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .constrainAs(cardno){
                                start.linkTo(image.end, margin = 20.dp)
                                top.linkTo(username.bottom, margin = 5.dp)

                            }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.add_card),
                        contentDescription = "",
                        modifier = Modifier
                            .constrainAs(image2) {
                                start.linkTo(parent.start, margin = 20.dp)
                                bottom.linkTo(parent.bottom, margin = 20.dp)
                            }
                    )

                    Text(
                        text = "Add New Card",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = softOrange,
                        modifier = Modifier
                            .clickable { }
                            .constrainAs(addcardtxt) {
                                start.linkTo(image2.end, margin = 20.dp)
                                bottom.linkTo(parent.bottom, margin = 30.dp)

                            }
                    )
                }
            }

            HeadingText(text = "UPI")

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color.White)
            ) {

                CommonRaw(
                    int = painterResource(id = R.drawable.upi),
                    text = "pracheta.b@oksbi",
                    text2 = "Remove",
                    onClick = { }
                )
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                    val (
                        image,
                        addupitxt
                    ) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.upi),
                        contentDescription = "",
                        modifier = Modifier
                            .constrainAs(image) {
                                start.linkTo(parent.start, margin = 20.dp)
                                bottom.linkTo(parent.bottom, margin = 20.dp)
                            }
                    )

                    Text(
                        text = "Add New UPI ID",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = softOrange,
                        modifier = Modifier
                            .clickable { }
                            .constrainAs(addupitxt) {
                                start.linkTo(image.end, margin = 20.dp)
                                bottom.linkTo(parent.bottom, margin = 30.dp)

                            }
                    )

                }
            }
            HeadingText(text = "Wallet")
            CommonRaw(
                int = painterResource(id = R.drawable.paytm),
                text ="Paytm" ,
                text2 = "Link Account",
                onClick = {isPaytmDialog = true }
            )

            CommonRaw(
                int =painterResource(id = R.drawable.outlined_mobikwik) ,
                text ="Mobikwik" ,
                text2 = "Link Account",
                onClick = { isMobiKwikDialog = true}
            )

            CommonRaw(
                int =painterResource(id = R.drawable.amazon) ,
                text = "Amazon Pay",
                text2 = "Link Account",
                onClick = {isAmazonDialog = true }

            )

            HeadingText(text = "Pay later")

            CommonRaw(
                int = painterResource(id = R.drawable.frame_2290),
                text = "+91 9830359697",
                text2 = "Remove",
                onClick = { }
            )
            // PaytmDialog logics
            if (isPaytmDialog)  {

                BasicAlertDialog(
                    onDismissRequest = { isPaytmDialog = false},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                        MobileNoPopup(
                            int = painterResource(id = R.drawable.paytm_logo),
                            cancel = {isPaytmDialog= false},
                            confirm = {isOTPok=true
                                isPaytmDialog = false
                            }
                        )
                }
            }

            // When OTP Is Correct
            if (isOTPok)  {

                BasicAlertDialog(
                    onDismissRequest = { isOTPok = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    OTPPopup(
                        cancel = { isOTPok = false},
                        confirm = {
                            isConfirmClicked = true
                            isOTPok = false
                                  },
                        resend = {}

                    )
                }
            }

            // When Confirm Clicked
            if (isConfirmClicked)  {

                BasicAlertDialog(
                    onDismissRequest = { isConfirmClicked = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    SuccessfullyPopup(
                        GoBack = {isConfirmClicked = false }

                    )
                }
            }

            // AmazonDialog logics
            if (isAmazonDialog)  {

                BasicAlertDialog(
                    onDismissRequest = { isAmazonDialog = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )

                ) {

                    MobileNoPopup(
                        int = painterResource(id = R.drawable.amazon2),
                        cancel = {isAmazonDialog= false},
                        confirm = {
                            isOTPok=true
                            isAmazonDialog= false
                        }
                    )
                }

            }

            // MobiKwikDialog logics
            if (isMobiKwikDialog)  {
                BasicAlertDialog(
                    onDismissRequest = { isMobiKwikDialog = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )

                ) {

                    MobileNoPopup(
                        int = painterResource(id = R.drawable.mobikwik),
                        cancel = {isMobiKwikDialog= false},
                        confirm = {
                            isOTPok=true
                            isMobiKwikDialog= false
                        }
                    )
                }
            }

        }
}




@Composable
fun HeadingText(text: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(Color.LightGray)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}