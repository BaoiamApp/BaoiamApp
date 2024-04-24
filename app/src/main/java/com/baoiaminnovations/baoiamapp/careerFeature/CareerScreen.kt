package com.baoiaminnovations.baoiamapp.careerFeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.exploreFeature.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CareerScreen(navController: NavController) {
    var text = remember { mutableStateOf("") }
    var active = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(text = text, active = active)

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
                .padding(15.dp),
            painter = painterResource(id = R.drawable.offer),
            contentDescription = stringResource(id = R.string.offer),
            onClick = { navController.navigate("scholarship") }
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
    CareerScreen(navController = navController)
}