package com.techtest.caseone.view.payment

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import com.techtest.caseone.presentation.PaymentViewModel
import com.techtest.caseone.view.payment.component.ItempayList


@SuppressLint("SuspiciousIndentation")
@Composable
fun PembayaranScreen(navCon : NavHostController,viewModel: PaymentViewModel){
    val myModel by viewModel.paymentSuccess.observeAsState()
     Log.d("TESS", myModel.toString())
    if(myModel?.isNotEmpty() == true)
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, top = 24.dp)){
        items(myModel!!.size, key = { myModel!!.elementAt(it).id!! } ){
            ItempayList(model = myModel!![it])
         }
        }
    if(myModel?.isEmpty() == true)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Blue)) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
           Text(text = "Tidak Ada Trsansaksi")
        }
    }
}

