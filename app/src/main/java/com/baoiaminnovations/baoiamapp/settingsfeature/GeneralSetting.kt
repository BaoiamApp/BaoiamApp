package com.baoiaminnovations.baoiamapp.settingsfeature

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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens


@Composable
fun GeneralSetting(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable{  }

        ){
            ConstraintLayout( modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)) {
                val (icon, text, icon2) = createRefs()


                Icon(
                    painter = painterResource(id = R.drawable.video_setting),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(icon){
                        start.linkTo(parent.start, margin = 30.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.chevron_bottom),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {  }
                        .constrainAs(icon2){
                            end.linkTo(parent.end, margin = 30.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(
                    text = "Video Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.constrainAs(text){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(icon.end, margin = 30.dp)
                    }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable{  }

        ){
            ConstraintLayout( modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)) {
                val (icon, text, icon2) = createRefs()


                Icon(
                    painter = painterResource(id = R.drawable.video_quality),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(icon){
                        start.linkTo(parent.start, margin = 30.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.chevron_bottom),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {  }
                        .constrainAs(icon2){
                            end.linkTo(parent.end, margin = 30.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(
                    text = "Video Quality",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.constrainAs(text){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(icon.end, margin = 30.dp)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable{ navHostController.navigate(Screens.NotificationSetting.route) }

        ){
            ConstraintLayout( modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)) {
                val (icon, text, icon2) = createRefs()


                Icon(
                    painter = painterResource(id = R.drawable.notification_setting),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(icon){
                        start.linkTo(parent.start, margin = 30.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {  }
                        .constrainAs(icon2){
                            end.linkTo(parent.end, margin = 27.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(
                    text = "Notification Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.constrainAs(text){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(icon.end, margin = 30.dp)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable{ navHostController.navigate(Screens.AppLanguage.route) }

        ){
            ConstraintLayout( modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)) {
                val (icon, text, icon2) = createRefs()


                Icon(
                    painter = painterResource(id = R.drawable.app_language),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(icon){
                        start.linkTo(parent.start, margin = 30.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {  }
                        .constrainAs(icon2){
                            end.linkTo(parent.end, margin = 27.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(
                    text = "App Language",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.constrainAs(text){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(icon.end, margin = 30.dp)
                    }
                )
            }
        }

    }
}