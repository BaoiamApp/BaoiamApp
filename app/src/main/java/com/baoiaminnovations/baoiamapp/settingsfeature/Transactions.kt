package com.baoiaminnovations.baoiamapp.settingsfeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R

@Preview
@Composable
fun Transactions() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
        ){
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (course, order, date_time, via, image, amout) = createRefs()

                Text(
                    text = "UX/UI Course",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(course) {
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(parent.top, margin = 20.dp)
                    }
                )
                Text(
                    text = "Order number : 888 555 222",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(order){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(course.bottom)
                    }
                )

                Text(
                    text = "16 Jan 2023, 8:30 PM",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.constrainAs(date_time){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(order.bottom)
                    }
                )

                Text(
                    text = "Via",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(via){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(date_time.bottom, margin = 5.dp)
                    }
                )

                Text(
                    text = "₹63,576",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(amout) {
                        end.linkTo(parent.end, margin = 20.dp)
                        top.linkTo(parent.top, margin = 20.dp)
                    }
                )

               Image(
                   painter = painterResource(id = R.drawable.google),
                   contentDescription = "",
                   modifier = Modifier.size(30.dp)
                       .constrainAs(image){
                        start.linkTo(via.end, margin = 10.dp)
                        top.linkTo(date_time.bottom)
                   }
               )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 20.dp)
        ){
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (course, order, date_time, via, image, amout) = createRefs()

                Text(
                    text = "Marketing Course",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(course) {
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(parent.top)
                    }
                )
                Text(
                    text = "Order number : 888 555 222",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(order){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(course.bottom)
                    }
                )

                Text(
                    text = "16 Jan 2023, 8:30 PM",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.constrainAs(date_time){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(order.bottom)
                    }
                )

                Text(
                    text = "Via",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(via){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(date_time.bottom, margin = 5.dp)
                    }
                )

                Text(
                    text = "₹6,576",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(amout) {
                        end.linkTo(parent.end, margin = 20.dp)
                        top.linkTo(parent.top)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.mastercard),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                        .constrainAs(image){
                            start.linkTo(via.end, margin = 10.dp)
                            top.linkTo(date_time.bottom)
                        }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(top = 45.dp)
        ){
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (course, order, date_time, via, image, amout) = createRefs()

                Text(
                    text = "Meme Creation",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(course) {
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(parent.top)
                    }
                )
                Text(
                    text = "Order number : 888 555 222",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(order){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(course.bottom)
                    }
                )

                Text(
                    text = "16 Jan 2023, 8:30 PM",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.constrainAs(date_time){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(order.bottom)
                    }
                )

                Text(
                    text = "Via",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(via){
                        start.linkTo(parent.start, margin = 20.dp)
                        top.linkTo(date_time.bottom, margin = 5.dp)
                    }
                )

                Text(
                    text = "₹576",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(amout) {
                        end.linkTo(parent.end, margin = 20.dp)
                        top.linkTo(parent.top)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.phonepe_logo),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                        .constrainAs(image){
                            start.linkTo(via.end, margin = 10.dp)
                            top.linkTo(date_time.bottom)
                        }
                )
            }
        }
    }
}