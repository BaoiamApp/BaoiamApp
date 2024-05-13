package com.baoiaminnovations.baoiamapp.myCourseFeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient

@Preview
@Composable
fun CourseTabContent() {


    Column(
        verticalArrangement = Arrangement.Center,
        modifier= Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Ongoing",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {  }
            )

            Text(
                text = "All",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {  }
            )
        }
            LazyRow(modifier = Modifier) {
                item {
                    LazyCard(
                    image = painterResource(id = R.drawable.offer),//change this drawable accordingly
                    title = "Graphic Design",
                    desc = "This is Graphic Design text"
                    )
                    LazyCard(
                    image = painterResource(id = R.drawable.enterotp),//change this drawable accordingly
                    title = "UI/UX Design",
                    desc = "This is UI/UX Design text"
                    )
                }
            }


    }
    
}

@Composable
fun LazyCard(
    image: Painter,
    title: String,
    desc: String
) {


            Card(
                colors = CardColors(
                    containerColor = Color.White,
                    disabledContainerColor = Color.White,
                    contentColor = Color.Unspecified,
                    disabledContentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .width(300.dp)
                    .height(360.dp)
                    .padding(start = 20.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Image(
                        painter = image,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)

                    )

                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(top = 10.dp)
                    ) {

                        val (title2, desc2, image) = createRefs()

                        Image(painter = painterResource(id = R.drawable.profile),//change this drawable accordingly
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(60.dp)
                                .constrainAs(image) {
                                    top.linkTo(parent.top)
                                    end.linkTo(parent.end, margin = 20.dp)
                                }

                        )

                        Text(
                            text = title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .constrainAs(title2) {
                                    start.linkTo(parent.start, margin = 10.dp)
                                    top.linkTo(parent.top, margin = 10.dp)
                                }
                        )

                        Text(
                            text = desc,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .constrainAs(desc2) {
                                    start.linkTo(parent.start, margin = 10.dp)
                                    top.linkTo(title2.bottom)
                                }
                        )


                    }
                    Row(modifier = Modifier.padding(start = 10.dp)) {
                        (1..5).forEach {

                            Image(
                                painter = painterResource(id = R.drawable.star_rating),//change this drawable accordingly
                                contentDescription = "",
                                modifier = Modifier
                                    .width(10.dp)
                                    .height(20.dp)

                            )
                        }
                        Text(
                            text = "(790)",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                        )

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        (1..6).forEach {
                            Surface(
                                modifier = Modifier
                                    .width(35.dp)
                                    .height(12.dp),
                                shape = RoundedCornerShape(8.dp),
                                color = Color.LightGray
                            ) {
                                Text(
                                    text = "Tag",
                                    fontSize = 9.sp,
                                    textAlign = TextAlign.Center

                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }


                    }

                    Text(
                        text = "5/78 lectures completed",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 10.dp)

                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(300.dp)
                            .padding(start = 10.dp, top = 10.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .width(200.dp)
                                .background(Color.LightGray, shape = RoundedCornerShape(7.dp))

                        ) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .width(30.dp)
                                    .clip(RoundedCornerShape(7.dp)),
                                thickness = 9.dp,
                                color = LinearGradient
                            )
                        }
                        Text(
                            text = "10%",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 20.dp)
                        )
                    }






                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .width(100.dp)
                            .padding(start = 10.dp)
                            .background(color = LinearGradient, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(Color.Transparent)

                    ) {
                        Text(
                            text = "Resume",
                            fontSize = 10.sp
                        )
                    }
                }
            }


}