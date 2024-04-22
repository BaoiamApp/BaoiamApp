package com.baoiaminnovations.baoiamapp.profileFeature


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navHostController: NavHostController) {

    var isdialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onPrimary)
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(15.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column() {
                    Text(
                        text = stringResource(id = R.string.name),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp, top = 15.dp),
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Text(
                        text = "user email address",
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }
            }
            IconButton(
                onClick = { navHostController.navigate(Screens.EditProfile.route) },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.edit_profile), contentDescription = "")
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
                .clickable {

                }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.wishlist), contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(
                        id = R.string.wishlist
                    ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.chevron_right), contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
                .clickable {

                }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.certificate), contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(
                        id = R.string.certificate
                    ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.chevron_right), contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
                .clickable {

                }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.refer_and_earn), contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(
                        id = R.string.referAndEarn
                    ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.chevron_right), contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
                .clickable {

                }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(
                        id = R.string.settings
                    ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.chevron_right), contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        TextButton(
            onClick = { 
                isdialog = true
            }, colors = ButtonDefaults.textButtonColors(
            ), modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Logout", style = TextStyle(brush = Brush.horizontalGradient(colors = listOf(
                LinearGradient, LinearGradient2
            )))
            )
            Image(painter = painterResource(id = R.drawable.logout),
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        if (isdialog){
            BasicAlertDialog(
                onDismissRequest = { isdialog = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            ) {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "See you soon!", modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(top = 30.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)

                    Text(
                        text = stringResource(id = R.string.logout_text),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(top = 20.dp),
                        fontSize = 16.sp)


                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = CenterVertically
                        ,modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)

                    ) {


                        Box(
                            modifier = Modifier
                                .fillMaxHeight()

                        ) {
                            OutlinedButton(onClick = { isdialog = false },
                                modifier = Modifier.height(75.dp).width(130.dp),
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(width = 2.dp,
                                    brush = Brush.horizontalGradient(colors = listOf(
                                        LinearGradient, LinearGradient2
                                    )))


                            ) {
                                Text(
                                    text = "Cancel",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(130.dp)
                        ) {
                            Button(onClick = {}, modifier = Modifier
                                .height(60.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            LinearGradient,
                                            LinearGradient2
                                        )
                                    ), shape = RoundedCornerShape(10.dp)
                                ),

                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)


                            ) {
                                Text(text = "Yes, Logout", fontSize = 15.sp, color = Color.White)
                            }
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp)
                            .padding(top = 20.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription ="" ,
                            modifier = Modifier.clickable {  }
                        )

                        Text(
                            text = "Remember log in details",
                            modifier = Modifier
                                .padding(start = 20.dp)
                        )
                    }

                }

            }
        }


    }

}
