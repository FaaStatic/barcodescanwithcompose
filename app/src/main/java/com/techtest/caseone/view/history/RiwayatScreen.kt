package com.techtest.caseone.view.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.techtest.caseone.presentation.RiwayatViewModel

@Composable
fun RiwayatScreen(navCon : NavHostController, viewModel : RiwayatViewModel){

    Box(modifier = Modifier.fillMaxSize().background(color = Color.Red)) {
        Column(modifier = Modifier.fillMaxSize()) {

        }
    }
}