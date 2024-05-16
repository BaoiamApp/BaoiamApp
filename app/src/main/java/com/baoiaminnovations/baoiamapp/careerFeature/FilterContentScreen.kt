package com.baoiaminnovations.baoiamapp.careerFeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.exploreFeature.components.SearchBar

@Composable
fun FilterContentScreen() {
    var text = remember { mutableStateOf("") }
    var active = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
            // Set the weight of the SearchBar to occupy most of the space

            // Add a Spacer to create some space between the SearchBar and the Image
            Spacer(modifier = Modifier.width(8.dp))

            // Adjust the modifier of the Image to fit within the Row
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Content creator Internship",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),

                )
            Spacer(modifier = Modifier.weight(1f))
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(
            start = 12.dp, top = 16.dp, end = 12.dp, bottom = 16.dp
        ), content = {
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
