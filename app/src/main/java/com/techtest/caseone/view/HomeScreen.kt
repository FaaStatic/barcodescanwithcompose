package com.techtest.caseone.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techtest.caseone.presentation.PaymentViewModel

@Composable
fun HomeScreen(navCon : NavHostController){
    val paymentViewModel : PaymentViewModel = viewModel()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)) {
            Text(text = "Saldo User : ", )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestHome(){
    val navControl = rememberNavController()
    HomeScreen(navCon = navControl)
}
