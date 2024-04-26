package com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.PasswordTextField
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@Composable
fun CreateNewPassword(navHostController: NavHostController) {

    var password = remember { mutableStateOf("") }
    var confirmPassword = remember { mutableStateOf("") }

    var passwordVisibility = remember { mutableStateOf(false) }
    var confirmPasswordVisibility = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .width(200.dp)
                .height(300.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(id = R.string.createNewPassword),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                lineHeight = 0.em
            ),
            modifier = Modifier.offset(y = (-40).dp)
        )
        PasswordTextField(
            password = password,
            visibility = passwordVisibility,
            id = R.string.password
        )
        Spacer(modifier = Modifier.height(5.dp))
        PasswordTextField(
            password = confirmPassword,
            visibility = confirmPasswordVisibility,
            id = R.string.confirmPassword
        )
        Button(
            onClick = { navHostController.navigate(Screens.PasswordUpdatedScreen.route) },
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp),
            shape = MaterialTheme.shapes.medium.copy(all = CornerSize(10.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFFFF7B00),
                                Color(0xFFFF0400)
                            )
                        )
                    )
                    .width(350.dp)
                    .height(45.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.resetPassword))
            }

        }
    }

}