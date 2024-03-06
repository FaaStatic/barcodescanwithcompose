package com.techtest.caseone.util.nav

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.techtest.caseone.R

data class BottomNavItem(val route : String, @DrawableRes val icon: Int, val label : String,)