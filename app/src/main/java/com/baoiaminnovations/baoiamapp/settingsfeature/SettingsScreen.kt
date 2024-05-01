package com.baoiaminnovations.baoiamapp.settingsfeature
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens


@Composable
fun SettingsScreen(navHostController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable{ navHostController.navigate(Screens.GeneralSetting.route) }
            ){
                ConstraintLayout( modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    val (icon, text, icon2) = createRefs()


                    Icon(
                        painter = painterResource(id = R.drawable.settings),
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
                            end.linkTo(parent.end, margin = 30.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                    )

                    Text(
                        text = "General Settings",
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
                    .clickable{  navHostController.navigate(Screens.Transactions.route) }

            ){
                ConstraintLayout( modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    val (icon, text, icon2) = createRefs()


                    Icon(
                        painter = painterResource(id = R.drawable.trans_history),
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
                            .clickable { }
                            .constrainAs(icon2){
                            end.linkTo(parent.end, margin = 30.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                    )

                    Text(
                        text = "Transaction History",
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
                    .clickable{ navHostController.navigate(Screens.PaymentOptions.route)  }

            ){
                ConstraintLayout( modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    val (icon, text, icon2) = createRefs()


                    Icon(
                        painter = painterResource(id = R.drawable.wallet),
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
                                end.linkTo(parent.end, margin = 30.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                    )

                    Text(
                        text = "Payment Options",
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
                    .clickable{  navHostController.navigate(Screens.HelpAndSupport.route) }

            ){
                ConstraintLayout( modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    val (icon, text, icon2) = createRefs()


                    Icon(
                        painter = painterResource(id = R.drawable.help),
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
                                end.linkTo(parent.end, margin = 30.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                    )

                    Text(
                        text = "Help and Support",
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
                    .clickable{  navHostController.navigate(Screens.AboutUs.route) }

            ){
                ConstraintLayout( modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    val (icon, text, icon2) = createRefs()


                    Icon(
                        painter = painterResource(id = R.drawable.about_us),
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
                                end.linkTo(parent.end, margin = 30.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                    )

                    Text(
                        text = "About Us",
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