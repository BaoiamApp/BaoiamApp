package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navHostController: NavHostController,viewModel: AppViewModel,activity: MainActivity) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(bottomBar = {

        if (currentDestination?.route == Screens.ExploreScreen.route || currentDestination?.route == Screens.MyCourseScreen.route
            || currentDestination?.route == Screens.CareerScreen.route || currentDestination?.route == Screens.ProfileScreen.route
        ) {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                val listOfScreens = listOf(
                    ScreensBottomNavigation.explore,
                    ScreensBottomNavigation.myCourse,
                    ScreensBottomNavigation.career,
                    ScreensBottomNavigation.profile
                )



                listOfScreens.forEach {
                    NavigationBarItem(

                        selected = currentDestination.route == it.route,
                        onClick = {
                            navHostController.popBackStack()
                            navHostController.navigate(it.route)

                        },
                        icon = {
                            Icon(
                                painter = painterResource(it.painterId),
                                contentDescription = stringResource(
                                    id = R.string.explore
                                ),
                                modifier = Modifier.padding(0.dp)
                            )
                        },
                        label = { Text(text = stringResource(id = it.titleId)) })
                }
            }
        }
    },
        topBar = {
            if (currentDestination?.route == Screens.ExploreScreen.route || currentDestination?.route == Screens.MyCourseScreen.route
                || currentDestination?.route == Screens.CareerScreen.route || currentDestination?.route == Screens.ProfileScreen.route
            ) {
                TopAppBar(title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            imageVector = Icons.Default.Person, contentDescription = stringResource(
                                id = R.string.profilePic
                            ),
                            modifier = Modifier
                                .clip(CircleShape)
                                .border(
                                    1.dp,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    shape = CircleShape
                                )
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = stringResource(id = R.string.welcome))
                    }
                }, actions = {
                    IconButton(onClick = { navHostController.navigate(Screens.SettingsScreen.route) }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                    }
                })
            }
        }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            NavHost(navHostController = navHostController,viewModel,activity)
        }
    }
}

