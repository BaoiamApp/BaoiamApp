package com.baoiaminnovations.baoiamapp.exploreFeature.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.exploreFeature.utils.CourseModel

@Composable
fun SingleRowOfCourse(courseModel: CourseModel) {
    Card {
        Card(
            modifier = Modifier.border(1.dp, Color.Black, RectangleShape).padding(start = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Course main image"
            )
            Text(text = "Complete UI/UX course ")
            Text(text = "Mayank Sharma")
            Text(text = "4.6")
            Text(text = "$100")
            OutlinedButton(
                onClick = { },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(text = "Buy Now")
            }
        }
    }
}