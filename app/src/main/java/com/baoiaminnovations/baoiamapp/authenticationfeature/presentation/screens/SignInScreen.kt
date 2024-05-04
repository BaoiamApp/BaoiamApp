package com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.PasswordTextField
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

    var visibility = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = username.value.length == 10) {
        if (username.value.isDigitsOnly() && username.value.length == 10) {
            navHostController.navigate(
                Screens.OtpVerificationForNumberScreen.otpVerficationWIthNameAndPhoneNumber(
                    "", username.value
                )
            )
        }
    }

    val sharedPreferences = activity.getSharedPreferences(
        Constants.SHARED_PREF_NAME,
        Context.MODE_PRIVATE
    )
    val editor = sharedPreferences.edit()
    editor.apply {
        putString(Constants.PREF_KEY, Constants.AUTH_SCREEN_VALUE)
    }.apply()


    val showCircularProgress = mutableStateOf(false)
    /*  LaunchedEffect(key1 = true) {
          viewModel.showVerifyingOTPDialogBox.value = true

      }*/
    viewModel.showVerificationAndOTPDialogBox.value = true


    val context = LocalContext.current
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
            contentDescription = "logo",
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
        BasicTextField(text = username, id = R.string.emailPhonenumber)
        PasswordTextField(password = password, visibility = visibility, id = R.string.password)
        TextButton(
            onClick = { navHostController.navigate(Screens.ForgotPassword.route) },
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp)
        ) {
            Text(text = stringResource(id = R.string.forgetPassword))
        }
        Button(
            onClick = {
                val result = viewModel.signInAuthenticate(username.value, password.value)
                if (result == Constants.VALIDATION_PASSED) {
                    showCircularProgress.value = true
                    viewModel.signIn(username.value, password.value)
                    viewModel.resultSignIn.observe(activity) {
                        if (it == Constants.SUCCESS) {
                            showCircularProgress.value = false
                            navHostController.popBackStack()
                            navHostController.navigate(Screens.ExploreScreen.route)

                        } else if (it == Constants.FAILURE) {
                            Toast.makeText(context, "Sign In Failed", Toast.LENGTH_SHORT).show()
                            showCircularProgress.value = false
                        }
                    }
                } else {
                    Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
                }
                //
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
                    Text(text = stringResource(id = R.string.login))
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
                text = stringResource(id = R.string.dontHaveAnAccount),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = {
                navHostController.navigate(Screens.SignUpScreen.route)
            }) {
                Text(
                    text = stringResource(id = R.string.register), style = TextStyle(
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