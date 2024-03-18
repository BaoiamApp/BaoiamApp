package com.baoiaminnovations.baoiamapp.onboardingfeature.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@Composable
fun OnboardingScreen3(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(LocalConfiguration.current.screenWidthDp.dp)
                .height(600.dp)
                .offset(y = (-50).dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Onboarding",
                modifier = Modifier
                    .width(200.dp)
                    .height(300.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.onboarding3),
                contentDescription = "Onboarding",
                modifier = Modifier
                    .width(300.dp)
                    .height(450.dp)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Fit
            )
        }
        Text(
            text = stringResource(id = R.string.baoiamIntro),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.offset(y = (-70).dp)
        )
        Button(
            onClick = { navHostController.navigate(Screens.SignInScreen.route) },
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally),
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
                Text(text = stringResource(id = R.string.startLearningButton))
            }

        }
    }

}