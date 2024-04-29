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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.BasicTextField
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components.OtpTextFields
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@Composable
fun OtpVerificationForNumberLogin(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity,
    name: String,
    phoneNumber: String
) {
    var otp =
        mutableStateOf("")
    /*    }
        var otp2 = remember {
            mutableStateOf("")
        }
        var otp3 = remember {
            mutableStateOf("")
        }
        var otp4 = remember {
            mutableStateOf("")
        }

        var otp5 = remember {
            mutableStateOf("")
        }

        var otp6 = remember {
            mutableStateOf("")
        }*/



    LaunchedEffect(key1 = name == "") {
        viewModel.phoneSignIn(phoneNumber, activity, viewModel.showVerificationAndOTPDialogBox)
    }

    viewModel.resultOfPhoneSignIn.observe(activity) {
        if (it == Constants.SUCCESS)
            navHostController.navigate(Screens.ExploreScreen.route)
        else if (it == Constants.FAILURE)
            Toast.makeText(activity, "Failed to log in. Please try again", Toast.LENGTH_SHORT)
                .show()
    }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .verticalScroll(rememberScrollState()),
    ) {
        if (viewModel.showVerificationAndOTPDialogBox.value) {
            DialogBox(
                dismissDialog = viewModel.showVerificationAndOTPDialogBox,
                "Verifying and getting OTP"
            )
        }
        if (viewModel.showVerifyingOTPDialogBox.value) {
            DialogBox(
                dismissDialog = viewModel.showVerifyingOTPDialogBox,
                message = "Verifying OTP"
            )
        }
        Image(
            painter = painterResource(id = R.drawable.enterotp),
            contentDescription = "Forgot Password",
            modifier = Modifier
                .width(300.dp)
                .height(450.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(id = R.string.otpVerfication),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                lineHeight = 0.em
            ),
            modifier = Modifier
                .offset(y = (-20).dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.enterOtp),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            BasicTextField(text = otp, id = R.string.enterOTP)
            /*      OtpTextFields(number = otp1, labelTextId = R.string.default_otp)
                  Spacer(modifier = Modifier.width(20.dp))
                  OtpTextFields(number = otp2, labelTextId = R.string.default_otp)
                  Spacer(modifier = Modifier.width(20.dp))
                  OtpTextFields(number = otp3, labelTextId = R.string.default_otp)
                  Spacer(modifier = Modifier.width(20.dp))
                  OtpTextFields(number = otp4, labelTextId = R.string.default_otp)
                  OtpTextFields(number = otp5, labelTextId = R.string.default_otp)
                  OtpTextFields(number = otp6, labelTextId = R.string.default_otp)*/
        }
        Button(
            onClick = {
                viewModel.showVerifyingOTPDialogBox.value = true
                val code =
                    otp.value
                if (name.isNotEmpty()) {
                    viewModel.phoneSignUpWithCode(code, name, phoneNumber)
                    viewModel.resultOFPhoneSignUpWithCode.observe(activity) {
                        if (it == Constants.SUCCESS) {
                            viewModel.showVerificationAndOTPDialogBox.value = false
                            navHostController.popBackStack()
                            navHostController.navigate(Screens.ExploreScreen.route)
                        } else if (it == Constants.FAILURE) {
                            Toast.makeText(context, "Failed to verify", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                } else if (name.isEmpty()) {
                    viewModel.phoneSignInWithCode(code)
                    viewModel.resultOFPhoneSignInWithCode.observe(activity) {
                        if (it == Constants.SUCCESS) {
                            navHostController.popBackStack()
                            navHostController.navigate(Screens.ExploreScreen.route)
                        } else if (it == Constants.FAILURE) {
                            Toast.makeText(
                                activity,
                                "Failed to verfily. Please try again",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
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
                Text(text = stringResource(id = R.string.verify))
            }

        }
        Spacer(modifier = Modifier.heightIn(20.dp))
        /*       TextButton(
                   onClick = { navHostController.navigate(Screens.CreateNewPasswordScreen.route) },
                   modifier = Modifier.align(Alignment.CenterHorizontally)
               ) {
                   Text(
                       text = stringResource(id = R.string.resend), style = TextStyle(
                           brush = Brush.horizontalGradient(
                               listOf(
                                   Color(0xFFFF7B00),
                                   Color(0xFFFF0400)
                               )
                           )
                       )
                   )
               }*/
    }
    viewModel.resultOfPhoneSignUp.observe(activity) {
        if (it == Constants.SUCCESS) {
            navHostController.navigate(Screens.ExploreScreen.route)
        } else if (it == Constants.FAILURE) {
            Toast.makeText(context, "Sign In Failed. Please try again", Toast.LENGTH_SHORT)
                .show()
        }
    }
}

@Composable
fun DialogBox(dismissDialog: MutableState<Boolean>, message: String) {
    AlertDialog(onDismissRequest = { dismissDialog.value = false }, confirmButton = {

    }, title = {
        Row {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = message)
        }
    })
}