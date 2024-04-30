package com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases.signUpAuthentication
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.PasswordTextField
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@Composable
fun SignUpScreen(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
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

    val showCircularProgress = mutableStateOf(false)

    var result = remember { mutableStateOf("") }

    val showPasswordAndConfirmPasswordTextField = remember { mutableStateOf(false) }

    //viewModel.showVerifyingOTPDialogBox.value = true
    viewModel.showVerificationAndOTPDialogBox.value = true

    LaunchedEffect(key1 = emailOrNumber.value.length == 10) {
        if (emailOrNumber.value.isDigitsOnly() && emailOrNumber.value.length == 10) {
            showPasswordAndConfirmPasswordTextField.value = true
        }
    }

    if (emailOrNumber.value.length < 10) {
        showPasswordAndConfirmPasswordTextField.value = false
    }

    val context = LocalContext.current
    val performSignUpValidation = remember { mutableStateOf(false) }
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
        if (!showPasswordAndConfirmPasswordTextField.value) {
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
        }
        Button(
            onClick = {
                val result = viewModel.signUpAuthenticate(
                    name.value,
                    emailOrNumber.value,
                    password.value,
                    confirmPassword.value
                )
                if (result == Constants.VALIDATION_PASSED) {
                    showCircularProgress.value = true
                    if (emailOrNumber.value.isDigitsOnly() && emailOrNumber.value.length == 10) {
                        viewModel.phoneSignUp(name.value, emailOrNumber.value, activity,viewModel)
                        navHostController.navigate(
                            Screens.OtpVerificationForNumberScreen.otpVerficationWIthNameAndPhoneNumber(
                                name.value,
                                emailOrNumber.value
                            )
                        )
                    } else {
                        viewModel.signUp(name.value, emailOrNumber.value, password.value)
                        viewModel.result.observe(activity) {
                            //   Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                            if (it == Constants.SUCCESS) {
                                showCircularProgress.value = false
                                navHostController.popBackStack()
                                navHostController.navigate(Screens.AccountCreatedScreen.route)

                            } else if (it == Constants.FAILURE) {
                                showCircularProgress.value = false
                                Toast.makeText(context, "Sign Up failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                } else {
                    Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
                }

                //navHostController.navigate(Screens.AccountCreatedScreen.route)
            },
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
                Row {
                    Text(text = stringResource(id = R.string.signup))
                    Spacer(modifier = Modifier.width(5.dp))
                    if (showCircularProgress.value) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            color = Color.White
                        )
                    }
                }
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
