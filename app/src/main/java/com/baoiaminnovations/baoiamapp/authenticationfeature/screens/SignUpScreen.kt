package com.baoiaminnovations.baoiamapp.authenticationfeature.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.components.PasswordTextField
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@Composable
fun SignUpScreen(navHostController: NavHostController) {
    var name = remember {
        mutableStateOf("")
    }
    var emailOrNumber = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    var confirmPassword = remember {
        mutableStateOf("")
    }
    var passwordVisibility = remember {
        mutableStateOf(true)
    }
    var passwordConfirmVisibility = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .offset(y = (-50).dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .width(200.dp)
                .height(300.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(id = R.string.createAnAccount),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                lineHeight = 0.em
            ),
            modifier = Modifier.offset(y = (-40).dp)
        )

        BasicTextField(text = name, id = R.string.name)
        BasicTextField(text = emailOrNumber, id = R.string.emailPhonenumber)
        PasswordTextField(
            password = password,
            visibility = passwordVisibility,
            id = R.string.password
        )
        PasswordTextField(
            password = confirmPassword,
            visibility = passwordConfirmVisibility,
            id = R.string.confirmPassword
        )
        Button(
            onClick = { navHostController.navigate(Screens.AccountCreatedScreen.route) },
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
                Text(text = stringResource(id = R.string.signup))
            }
        }
        Text(
            text = stringResource(id = R.string.orLoginWith),
            modifier = Modifier
                .padding(top = 20.dp)
                .alpha(0.7f),
            color = Color.Gray,
            fontSize = 12.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    tint = Color.Unspecified
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook",
                    tint = Color.Unspecified
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy((-7).dp)
        ) {
            Text(
                text = stringResource(id = R.string.alreadyHaveAnAccount),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = {
                navHostController.navigate(Screens.SignUpScreen.route)
            }) {
                Text(
                    text = stringResource(id = R.string.signIn), style = TextStyle(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFFFF7B00),
                                Color(0xFFFF0400)
                            )
                        )
                    ),
                    textDecoration = TextDecoration.Underline
                )
            }
        }

    }

}