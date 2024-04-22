package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Scanner
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.baoiaminnovations.baoiamapp.R

sealed class ScreensBottomNavigation(
    val route: String,
    val titleId: Int,
    val painterId: Int
) {
    object explore :
        ScreensBottomNavigation(
            "explore_screen",
            R.string.explore,
            R.drawable.explore
        )

    object myCourse :
        ScreensBottomNavigation(
            "my_course_screen",
            R.string.myCourse,
            R.drawable.courses
        )

    object career :
        ScreensBottomNavigation("career_screen", R.string.career, R.drawable.career)

    object profile : ScreensBottomNavigation(
        "profile_screen",
        R.string.profile,
        R.drawable.profile
    )

}