package com.baoiaminnovations.baoiamapp.onboardingfeature.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens

@OptIn(ExperimentalTextApi::class)
@Composable
fun OnBoardingScreen1(navHostController: NavHostController) {
    var show = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .verticalScroll(rememberScrollState())
    ) {
        AnimatedVisibility(visibleState = show, enter = slideInHorizontally(
            animationSpec = tween(
                durationMillis = 800,
                easing = LinearOutSlowInEasing
            )
        ) { it }) {
            Text(
                text = stringResource(id = R.string.welcomeText),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp, start = 10.dp),
                style = TextStyle(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFFFF7B00),
                            Color(0xFFFF0400)
                        )
                    )
                )
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.welcomeText2),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 5.dp, start = 10.dp)
                    .zIndex(10f),
                color = Color.Gray
            )
            Image(
                painter = painterResource(id = R.drawable.onboarding1),
                contentDescription = "Onboarding",
                modifier = Modifier
                    .width(350.dp)
                    .height(500.dp)
                    .padding(10.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Fit
            )
        }
        Button(
            onClick = { navHostController.navigate(Screens.OnBoardingScreen2.route) },
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 110.dp),
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
                Text(text = stringResource(id = R.string.next))
            }

        }
    }
}