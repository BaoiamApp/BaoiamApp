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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens
import com.baoiaminnovations.baoiamapp.ui.theme.Button1Preview
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient2


@Composable
fun HelpAndSupport(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text ="About Us",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
            )

        Text(
            text = stringResource(id = R.string.help_support_about_us),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(20.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ){
            ConstraintLayout(Modifier.fillMaxSize()) {

                val (text1, text2, button) = createRefs()

                Text(
                    text ="Chat with Us",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(text1){
                            start.linkTo(parent.start, margin = 20.dp)

                        }

                )


                    Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        onClick = { navHostController.navigate(Screens.ChatBot.route) },
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        LinearGradient,
                                        LinearGradient2
                                    )
                                ), shape = RoundedCornerShape(8.dp)
                            )
                            .height(40.dp)
                            .width(130.dp)
                            .constrainAs(button) {
                                end.linkTo(parent.end, margin = 20.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }

                    ) {
                        Text(text = "Open chat", fontSize = 17.sp, color = Color.White)
                    }

                Text(
                    text = stringResource(id = R.string.chatwithus_text),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .constrainAs(text2) {
                            top.linkTo(text1.bottom, margin = 30.dp)
                            start.linkTo(parent.start, margin = 20.dp)
                        }
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(top = 20.dp)
                .clickable { navHostController.navigate(Screens.ContactUs.route) }
        ){
            ConstraintLayout(Modifier.fillMaxSize()) {

                val (text1, text2, icon) = createRefs()

                Text(
                    text ="Contact Us",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(text1){
                            start.linkTo(parent.start, margin = 20.dp)
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { navHostController.navigate(Screens.ContactUs.route) }
                        .constrainAs(icon){
                            end.linkTo(parent.end, margin = 20.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )



                Text(
                    text = stringResource(id = R.string.chatwithus_text),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(20.dp)
                        .constrainAs(text2) {
                            top.linkTo(text1.bottom)
                            start.linkTo(parent.start)
                        }
                )
            }

        }

    }
    
}