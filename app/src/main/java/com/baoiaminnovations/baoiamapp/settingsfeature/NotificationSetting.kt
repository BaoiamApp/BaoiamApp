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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.ui.theme.Typography

@Preview
@Composable
fun NotificatiinSetting() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        // code snippet for course related notification
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ){
        ConstraintLayout( modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {
            val (icon, text1, text2, toggle) = createRefs()


            Icon(
                painter = painterResource(id = R.drawable.notifications_none),
                contentDescription = "",
                modifier = Modifier.constrainAs(icon){
                    start.linkTo(parent.start, margin = 5.dp)
                    top.linkTo(parent.top, margin = 5.dp)
                }
            )

            Image(
                painter = painterResource(id = R.drawable.toggle_on),
                contentDescription = "",
                modifier = Modifier
                    .clickable {  }
                    .constrainAs(toggle){
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )

            Text(
                text = "Course related",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.constrainAs(text1){
                    top.linkTo(parent.top, margin = 5.dp)
                    start.linkTo(icon.end, margin = 20.dp)
                }
            )


            Text(
                text = "Receive notification about \ncourse " +
                        "progress & activities.",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(text2){
                    top.linkTo(text1.bottom, margin = 15.dp)
                    start.linkTo(icon.end, margin = 20.dp)
                }
            )


        }
    }
        // code snippet for study reminders notification
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp)
            .padding(top = 20.dp)
    ){
        ConstraintLayout( modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {
            val (icon, text1, text2, toggle) = createRefs()


            Icon(
                painter = painterResource(id = R.drawable.notifications_none),
                contentDescription = "",
                modifier = Modifier.constrainAs(icon){
                    start.linkTo(parent.start, margin = 5.dp)
                    top.linkTo(parent.top, margin = 5.dp)
                }
            )

            Image(
                painter = painterResource(id = R.drawable.toggle_on),
                contentDescription = "",
                modifier = Modifier
                    .clickable {  }
                    .constrainAs(toggle){
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )

            Text(
                text = "Study reminders",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.constrainAs(text1){
                    top.linkTo(parent.top, margin = 5.dp)
                    start.linkTo(icon.end, margin = 20.dp)
                }
            )


            Text(
                text = "Receive notification that\nreminds you" +
                        " to study at \ntimes you set for yourself.",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(text2){
                    top.linkTo(text1.bottom, margin = 15.dp)
                    start.linkTo(icon.end, margin = 20.dp)
                }
            )


        }
    }
        // code snippet for promotions notification
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 20.dp)
        ){
            ConstraintLayout( modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)) {
                val (icon, text1, text2, toggle) = createRefs()


                Icon(
                    painter = painterResource(id = R.drawable.notifications_none),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(icon){
                        start.linkTo(parent.start, margin = 5.dp)
                        top.linkTo(parent.top, margin = 5.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.toggle_off),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {  }
                        .constrainAs(toggle){
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )

                Text(
                    text = "Promotions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.constrainAs(text1){
                        top.linkTo(parent.top, margin = 5.dp)
                        start.linkTo(icon.end, margin = 20.dp)
                    }
                )


                Text(
                    text = "Receive notification on \noffers & " +
                            "promotions on courses.",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.constrainAs(text2){
                        top.linkTo(text1.bottom, margin = 15.dp)
                        start.linkTo(icon.end, margin = 20.dp)
                    }
                )


            }
        }


    }
}