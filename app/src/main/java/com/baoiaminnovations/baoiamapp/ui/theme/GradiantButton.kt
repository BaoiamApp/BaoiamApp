package com.baoiaminnovations.baoiamapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Button1Preview(
    text: String,
    onClick: () -> Unit,

    modifier: Modifier


    ) {


    Surface(modifier = Modifier
        .width(160.dp)
        .height(44.dp)
        , shape = RoundedCornerShape(8.dp)) {
        Button(onClick = {onClick()}, modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LinearGradient,
                        LinearGradient2
                    )
                )
            ),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)


        ) {
            Text(text = text, fontSize = 20.sp, color = White)
        }
        
    }

}




