package com.baoiaminnovations.baoiamapp.careerFeature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.careerFeature.ui.theme.BaoiamAppTheme
import com.baoiaminnovations.baoiamapp.exploreFeature.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularSearch() {
    var text = remember { mutableStateOf("") }
    var active = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterStart)
            ) {
                SearchBar(text = text, active = active)
            }
            ImageClickable(
                modifier = Modifier
                    .width(60.dp)
                    .height(65.dp)
                    .padding(15.dp)
                    .align(Alignment.BottomEnd),
                onClick = { },
                painter = painterResource(id = R.drawable.filter_icon),
                contentDescription = stringResource(id = R.string.offer)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            Text(
                text = "Popular Searches",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
                modifier = Modifier.weight(1f)
            )
        }

        // Popular search items
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // UI/UX Design
            PopularSearchItem(text = "UI/UX Design")

            // Python
            PopularSearchItem(text = "Python")

            // End of first row
        }

        // Second row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // AWS
            PopularSearchItem(text = "AWS")

            // Artificial Intelligence
            PopularSearchItem(text = "Artificial Intelligence")

            // End of second row
        }
    }
}

@Composable
fun PopularSearchItem(text: String) {
    Card(
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PopularSearchPreview() {
    val navController = rememberNavController()
    PopularSearch()
}

