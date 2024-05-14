package com.baoiaminnovations.baoiamapp.careerFeature

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.common.presentation.Screens
import com.baoiaminnovations.baoiamapp.exploreFeature.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CareerScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    var text = remember { mutableStateOf("") }
    var active = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            Row(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                SearchBar(text = text, active = active)
            }
            ImageClickable(
                modifier = Modifier
                    .width(65.dp)
                    .height(65.dp)
                    .padding(15.dp),
                onClick = { navHostController.navigate(Screens.ScholarshipScreen.route) },
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
                text = "Internship",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View More",
                modifier = Modifier.clickable { /* Handle click */ }
            )
        }

        ImageClickable(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(15.dp),
            onClick = { navHostController.navigate(Screens.ScholarshipScreen.route) },
            painter = painterResource(id = R.drawable.scholarship_banner),
            contentDescription = stringResource(id = R.string.offer)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Internship",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = active.value,
                onCheckedChange = { active.value = it },
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            content = {
                items(100) {
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.offer),
                            contentDescription = null, // provide content description if available
                            modifier = Modifier
                                .fillMaxSize() // Match parent width and height
                                .aspectRatio(1f), // Maintain aspect ratio
                            contentScale = ContentScale.FillBounds // adjust content scale as needed
                        )
                    }
                }
            })
    }
}

@Composable
fun ImageClickable(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String?,
    onClick: () -> Unit
) {
    Image(
        modifier = modifier
            .clickable(onClick = onClick),
        painter = painter,
        contentDescription = contentDescription
    )
}

@Preview
@Composable
fun CareerScreenPreview() {
    val navController = rememberNavController()
    //CareerScreen(navController = navController)
}
