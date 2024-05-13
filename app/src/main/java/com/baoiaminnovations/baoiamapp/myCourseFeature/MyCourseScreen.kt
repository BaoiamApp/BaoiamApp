package com.baoiaminnovations.baoiamapp.myCourseFeature

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient
import com.baoiaminnovations.baoiamapp.ui.theme.LinearGradient2
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun MyCourse() {
        val scope = rememberCoroutineScope()
        val pagerState = rememberPagerState {3}

        val tabItems = listOf(
            TabItems(title = "Activity", content = {}),
            TabItems(title = "Courses",content = {CourseTabContent()}),
            TabItems(title = "LiveClass",content = {})
        )

        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }


    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onPrimary)
                .fillMaxHeight(.26f)
                .width(200.dp)

        ) {

            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(70.dp)

            )
            Text(
                text = stringResource(id = R.string.name),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding( top = 10.dp),
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "user email address",
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(10.dp))


        Box(
            contentAlignment = TopCenter,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .border(width = 1.dp, LightGray, shape = RoundedCornerShape(10.dp))
        ){
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { White}
            ) {
                tabItems.forEachIndexed { index, tabItems ->

                    LeadingIconTab(
                        selected = index==pagerState.currentPage,
                        modifier = Modifier.background(
                        color = if (index==pagerState.currentPage) LinearGradient else Transparent,
                            shape = RoundedCornerShape(10.dp)
                            ),
                        onClick = {
                            selectedTabIndex = index
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(
                            text = tabItems.title,
                            color = if (pagerState.currentPage == index) White else Gray

                            ) },
                        icon = { /*TODO*/ },
                    )
                }
            }
        }
        HorizontalPager(state = pagerState) {index ->

            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxSize()
            ){
                tabItems[index].content()
            }
        }
    }
}



data class TabItems(
    val title: String,
    val content: @Composable ()-> Unit
    )






