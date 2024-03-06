package com.techtest.caseone.view.payment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.techtest.caseone.domain.model.TransactionEntitiy

@Composable
fun detailPaymentScreen(navcon : NavController, model : TransactionEntitiy){
    Scaffold {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Text(text = "Merchant : ${model.nama_merchant}")
            Text(text = "Nominal Transaksi : ${model.nominal}")
            Text(text = "ID Transaksi : ${model.id_trx}")
            Button(onClick = { navcon.navigate("home") }) {
                Text(text = "Kembali")
            }
        }
    }
}

