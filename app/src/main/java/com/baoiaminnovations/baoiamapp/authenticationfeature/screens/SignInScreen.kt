package com.baoiaminnovations.baoiamapp.authenticationfeature.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navHostController: NavHostController) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var visibility by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Onboarding",
            modifier = Modifier
                .width(200.dp)
                .height(300.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(id = R.string.signIn),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                lineHeight = 0.em
            ),
            modifier = Modifier.offset(y = (-40).dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            label = { Text(text = stringResource(id = R.string.emailPhonenumber)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            label = { Text(text = stringResource(id = R.string.password)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            trailingIcon = {
                IconButton(onClick = { visibility = !visibility }) {
                    Icon(
                        imageVector = if (visibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = "visibility"
                    )
                }
            },
            visualTransformation = if (visibility) PasswordVisualTransformation() else VisualTransformation.None
        )
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp)
        ) {
            Text(text = stringResource(id = R.string.forgetPassword))
        }
        Button(
            onClick = { },
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
                Text(text = stringResource(id = R.string.login))
            }

        }
        Text(
            text = stringResource(id = R.string.orLoginWith),
            modifier = Modifier
                .padding(top = 20.dp)
                .alpha(0.7f),
            color = Color.Gray
        )
        Text(text = buildAnnotatedString {
            append(stringResource(id = R.string.dontHaveAnAccount))
            withStyle(
                style = SpanStyle(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFFFF7B00),
                            Color(0xFFFF0400)
                        )
                    )
                )
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    append(stringResource(id = R.string.register))
                }
            }
        }
        )
    }
}