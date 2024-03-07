package com.techtest.caseone.view.payment

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.presentation.DataStoreViewModel

@Composable
fun detailPaymentScreen(navcon : NavController, model : TransactionEntitiy,  viewModel:DataStoreViewModel){
    val saldo = viewModel.getData().collectAsState(initial = 0)
    LaunchedEffect(Unit){
        Log.d("saldonya", saldo.value.toString())
        var total = saldo.value - model.nominal!!
        viewModel.updateData(total)
    }

    Scaffold {
        Column  ( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Text(text = "Merchant : ${model.nama_merchant}", fontSize = 16.sp, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))

            Text(text = "Nominal Transaksi : ${model.nominal}",fontSize = 16.sp, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))
            Text(text = "ID Transaksi : ${model.id_trx}",fontSize = 16.sp, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))
            Button(onClick = { navcon.navigate("home") }, modifier = Modifier.padding(top = 16.dp).height(55.dp)) {
                Text(text = "Kembali",fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(bottom = 16.dp))
            }
        }
    }
}

