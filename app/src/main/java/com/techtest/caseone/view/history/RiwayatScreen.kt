package com.techtest.caseone.view.history

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.navigation.NavHostController
import com.techtest.caseone.presentation.RiwayatViewModel
import com.techtest.caseone.view.history.component.ItemHistoryList
import com.techtest.caseone.view.payment.component.ItempayList

@Composable
fun RiwayatScreen(navCon : NavHostController, viewModel : RiwayatViewModel){
    val data by viewModel.riwayatList.observeAsState()
        Log.d("TESTIS", "RiwayatScreen: ${data.toString()}")
    if(data?.isNotEmpty() == true)
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp,top = 24.dp)){
            items(data!!.size, key = { data!!.elementAt(it).id!! } ){
                ItemHistoryList (model = data!![it])
            }
        }
    if(data?.isEmpty() == true)
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Tidak Ada Trsansaksi")
            }
        }
}