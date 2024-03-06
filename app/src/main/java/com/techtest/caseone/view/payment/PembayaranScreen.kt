package com.techtest.caseone.view.payment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.presentation.PaymentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun PembayaranScreen(navCon : NavHostController,viewModel: PaymentViewModel){
    val myModel by viewModel.paymentSuccess.observeAsState()
     Log.d("TESS", myModel.toString())
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Blue)) {
        Column(modifier = Modifier.fillMaxSize()) {

        }
    }
}
