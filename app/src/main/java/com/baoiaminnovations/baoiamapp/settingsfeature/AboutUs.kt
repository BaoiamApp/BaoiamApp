package com.baoiaminnovations.baoiamapp.settingsfeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient

@Preview
@Composable
fun AboutUs() {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
            Text(
                text ="Welcome to Baoiam",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .width(350.dp)
                    .height(190.dp)
            )

            Text(
                text ="Our Story",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )

            Text(
                text = stringResource(id = R.string.our_story),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth().height(165.dp)
            )

            Text(
                text ="Our Achievements",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Row(
                modifier = Modifier
                    .width(330.dp)
                    .height(130.dp)
                    .padding(top = 20.dp)
            ) {

                 Surface(color = Color.White,
                     modifier = Modifier
                         .width(80.dp)
                         .height(90.dp)
                         .padding(start = 10.dp)
                         .background(Color.White)
                         .border(
                             width = 1.dp, color = LinearGradient,
                             shape = RoundedCornerShape(8.dp)
                         )
                 ) {
                        Text(
                            text = "2M+",
                            fontSize = 20.sp,
                            color= LinearGradient,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        Text(
                            text = "Active \nLearners",
                            textAlign = TextAlign.Center,
                            color= Color.Gray,
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(top = 40.dp)
                        )
                 }
                Surface(color = Color.White,
                    modifier = Modifier
                        .width(80.dp)
                        .height(90.dp)
                        .padding(start = 10.dp)
                        .background(Color.White)
                        .border(
                            width = 1.dp, color = LinearGradient,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = "20M+",
                        fontSize = 20.sp,
                        color= LinearGradient,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )

                    Text(
                        text = "Minutes \nWatched",
                        textAlign = TextAlign.Center,
                        color= Color.Gray,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(top = 40.dp)
                    )
                }

                Surface(color = Color.White,
                    modifier = Modifier
                        .width(80.dp)
                        .height(90.dp)
                        .padding(start = 10.dp)
                        .background(Color.White)
                        .border(
                            width = 1.dp, color = LinearGradient,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = "500+",
                        fontSize = 20.sp,
                        color= LinearGradient,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )

                    Text(
                        text = "Top \nEducators",
                        textAlign = TextAlign.Center,
                        color= Color.Gray,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(top = 40.dp)
                    )
                }
                Surface(color = Color.White,
                    modifier = Modifier
                        .width(80.dp)
                        .height(90.dp)
                        .padding(start = 10.dp)
                        .border(
                            width = 1.dp, color = LinearGradient,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = "100+",
                        fontSize = 20.sp,
                        color= LinearGradient,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )

                    Text(
                        text = "Daily Live \nClasses",
                        textAlign = TextAlign.Center,
                        color= Color.Gray,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(top = 40.dp)
                    )
                }
            }

            Text(
                text ="Our Partners",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)

        )
    }
    
}