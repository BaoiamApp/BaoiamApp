package com.baoiaminnovations.baoiamapp.settingsfeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient2

@Preview
@Composable
fun ChatBot() {
    var text by remember {
        mutableStateOf("")
    }

    // code snippet for bottom textfield
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (textfield, surface, surface2, surface3,
            surface4, boticon, boticon2,raw) = createRefs()

        Card(
            colors = CardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.White,
            contentColor = Color.Unspecified,
            disabledContentColor = Color.White
        ),
            shape = RoundedCornerShape(30.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .width(350.dp)
                .height(55.dp)
                .constrainAs(textfield) {
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                }

        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.microphone),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 60.dp)
                            .clickable { }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.send),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .clickable { }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .border(width = 2.dp, color = Color.White),
                placeholder = {
                    Text(text = stringResource(id = R.string.write_your_msg))
                }
            )
        }

        // code snippet for users chat msg 1
        Surface(
            modifier = Modifier
                .width(250.dp)
                .height(75.dp)
                .constrainAs(surface) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(parent.top, margin = 20.dp)
                },
            color = Color.LightGray,
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 20.dp
            )
        ) {
            Text(
                text = stringResource(id = R.string.chat_msg_1),
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
        }

        // code snippet for systems chat msg 1
        Surface(
            modifier = Modifier
                .width(250.dp)
                .height(125.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            LinearGradient,
                            LinearGradient2
                        )
                    ), shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .constrainAs(surface2) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(surface.bottom, margin = 20.dp)
                },
            color = Color.Transparent,

            ) {
            Text(
                text = stringResource(id = R.string.chat_msg_2),
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
        }

        // code snippet for system icon 1
        Image(
            painter = painterResource(
                id = R.drawable.baseline_auto_awesome_24
            ),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .constrainAs(boticon) {
                    end.linkTo(surface2.start, margin = 15.dp)
                    bottom.linkTo(surface2.bottom)
                }
        )

        // code snippet for users chat msg 2
        Surface(
            modifier = Modifier
                .width(140.dp)
                .height(55.dp)
                .constrainAs(surface3) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(surface2.bottom, margin = 20.dp)
                },
            color = Color.LightGray,
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 20.dp
            )
        ) {
            Text(
                text = "Yes, please",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                color = Color.Black,
                modifier = Modifier.padding(15.dp)
            )
        }

        // code snippet for systems chat msg 2
        Surface(
            modifier = Modifier
                .width(260.dp)
                .height(220.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            LinearGradient,
                            LinearGradient2
                        )
                    ), shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .constrainAs(surface4) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(surface3.bottom, margin = 20.dp)
                },
            color = Color.Transparent,

            ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                // code snippet for text inside systems chat msg 2

                Text(
                    text = "Please contact our team via",
                    fontSize = 17.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 15.dp)
                )

                // code snippet for card contact number inside systems chat msg 2
                Card(
                    colors = CardColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White,
                        contentColor = Color.Unspecified,
                        disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    modifier = Modifier
                        .width(210.dp)
                        .height(70.dp)
                        .padding(top = 10.dp)
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .clickable { }
                    ) {


                        ConstraintLayout(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            val (call, callicon, phoneno) = createRefs()


                            Image(
                                painter = painterResource(id = R.drawable.call),
                                contentDescription = "",
                                modifier = Modifier.constrainAs(callicon) {
                                    start.linkTo(parent.start, margin = 10.dp)
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                }
                            )

                            Text(
                                text = "Contact Number",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.constrainAs(call) {
                                    start.linkTo(callicon.end, margin = 10.dp)
                                    top.linkTo(parent.top, margin = 8.dp)

                                }
                            )
                            Text(
                                text = "+91 XXXXXXXXXX",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.constrainAs(phoneno) {
                                    start.linkTo(callicon.end, margin = 10.dp)
                                    top.linkTo(call.bottom)
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                // code snippet for card email address inside systems chat msg 2
                Card(
                    colors = CardColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White,
                        contentColor = Color.Unspecified,
                        disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    modifier = Modifier
                        .width(210.dp)
                        .height(70.dp)
                        .padding(top = 10.dp)
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .clickable { }
                    ) {


                        ConstraintLayout(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            val (mail, mailicon,emailadd ) = createRefs()


                            Image(
                                painter = painterResource(id = R.drawable.mail),
                                contentDescription ="",
                                modifier = Modifier.constrainAs(mailicon){
                                    start.linkTo(parent.start, margin = 10.dp)
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                }
                            )

                            Text(
                                text = "Email address",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.constrainAs(mail){
                                    start.linkTo(mailicon.end, margin = 10.dp)
                                    top.linkTo(parent.top, margin = 8.dp)

                                }
                            )
                            Text(
                                text = "help@baoiam.com",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.constrainAs(emailadd){
                                    start.linkTo(mailicon.end, margin = 10.dp)
                                    top.linkTo(mail.bottom)
                                }
                            )
                        }
                    }
                }
            }
        }

        // code snippet for system icon 2
        Image(
            painter = painterResource(
                id = R.drawable.baseline_auto_awesome_24
            ),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .constrainAs(boticon2) {
                    end.linkTo(surface4.start, margin = 15.dp)
                    bottom.linkTo(surface4.bottom)
                }
        )

        // code snippet for feedback text
        Row(
            modifier = Modifier
                .width(250.dp)
                .height(40.dp)
                .constrainAs(raw) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(surface4.bottom, margin = 10.dp)
                }
        ) {
        Text(
            text = "Solved your query?",
            fontSize = 16.sp
        )
            Image(
                painter = painterResource(id = R.drawable.like),
                contentDescription ="",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .clickable {  }
            )
            Image(
                painter = painterResource(id = R.drawable.dislike),
                contentDescription ="",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {  }
            )
        }
    }
}


