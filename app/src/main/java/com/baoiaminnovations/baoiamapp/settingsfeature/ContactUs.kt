package com.baoiaminnovations.baoiamapp.settingsfeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R

@Preview
@Composable
fun ContactUs() {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.contact_us),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
        )

        // code snippet for card social media

        Card(colors = CardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.White,
            contentColor = Color.Unspecified,
            disabledContentColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 30.dp)
                .background(color = Color.White)
        ) {

            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text ="Social Media",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                )

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 20.dp)
                    .clickable { }
                ) {


                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val ( instagram, instaicon,text ) = createRefs()


                        Image(
                            painter = painterResource(id = R.drawable.instagram),
                            contentDescription ="",
                            modifier = Modifier.constrainAs(instaicon){
                                start.linkTo(parent.start, margin = 25.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )

                        Text(
                            text = "Insragram",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.constrainAs(instagram){
                                start.linkTo(instaicon.end, margin = 25.dp)
                                top.linkTo(parent.top)

                            }
                        )
                        Text(
                            text = "@baoiam",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(text){
                                start.linkTo(instaicon.end, margin = 25.dp)
                                top.linkTo(instagram.bottom, margin = 5.dp)
                            }
                        )


                    }
                }

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 20.dp)
                    .clickable { }
                ) {


                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val ( twiter, twitericon,text ) = createRefs()


                        Image(
                            painter = painterResource(id = R.drawable.twiter),
                            contentDescription ="",
                            modifier = Modifier.constrainAs(twitericon){
                                start.linkTo(parent.start, margin = 25.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )

                        Text(
                            text = "Twitter",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.constrainAs(twiter){
                                start.linkTo(twitericon.end, margin = 25.dp)
                                top.linkTo(parent.top)

                            }
                        )
                        Text(
                            text = "@baoiam",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(text){
                                start.linkTo(twitericon.end, margin = 25.dp)
                                top.linkTo(twiter.bottom, margin = 5.dp)
                            }
                        )


                    }
                }

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 20.dp)
                    .clickable { }
                ) {


                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val (linkedin, linkedicon,text ) = createRefs()


                        Image(
                            painter = painterResource(id = R.drawable.linked_in),
                            contentDescription ="",
                            modifier = Modifier.constrainAs(linkedicon){
                                start.linkTo(parent.start, margin = 30.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )

                        Text(
                            text = "Linked In",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.constrainAs(linkedin){
                                start.linkTo(linkedicon.end, margin = 25.dp)
                                top.linkTo(parent.top)

                            }
                        )
                        Text(
                            text = "@baoiam",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(text){
                                start.linkTo(linkedicon.end, margin = 25.dp)
                                top.linkTo(linkedin.bottom, margin = 5.dp)
                            }
                        )


                    }
                }
            }

        }

        // code snippet for card customer support

        Card(colors = CardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.White,
            contentColor = Color.Unspecified,
            disabledContentColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(top = 30.dp)
                .background(color = Color.White)
        ) {

            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text ="Customer Support",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                )

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 20.dp)
                    .clickable { }
                ) {


                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val (call, callicon,text ) = createRefs()


                        Image(
                            painter = painterResource(id = R.drawable.call),
                            contentDescription ="",
                            modifier = Modifier.constrainAs(callicon){
                                start.linkTo(parent.start, margin = 25.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )

                        Text(
                            text = "Contact Number",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.constrainAs(call){
                                start.linkTo(callicon.end, margin = 25.dp)
                                top.linkTo(parent.top)

                            }
                        )
                        Text(
                            text = "+91 XXXXXXXXXX",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(text){
                                start.linkTo(callicon.end, margin = 25.dp)
                                top.linkTo(call.bottom, margin = 5.dp)
                            }
                        )
                    }
                }

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 20.dp)
                    .clickable { }
                ) {


                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val (
                            socialMedia, mail, mailicon,text ) = createRefs()


                        Image(
                            painter = painterResource(id = R.drawable.mail),
                            contentDescription ="",
                            modifier = Modifier.constrainAs(mailicon){
                                start.linkTo(parent.start, margin = 25.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )

                        Text(
                            text = "Email address",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.constrainAs(mail){
                                start.linkTo(mailicon.end, margin = 25.dp)
                                top.linkTo(parent.top)

                            }
                        )
                        Text(
                            text = "help@baoiam.com",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.constrainAs(text){
                                start.linkTo(mailicon.end, margin = 25.dp)
                                top.linkTo(mail.bottom, margin = 5.dp)
                            }
                        )
                    }
                }
            }
        }

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .size(170.dp).padding(top = 20.dp)
            )
    }
}