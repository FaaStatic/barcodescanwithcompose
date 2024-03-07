package com.techtest.caseone.view.payment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtest.caseone.domain.model.TransactionEntitiy


@Composable
fun ItempayList(model : TransactionEntitiy){
    Box(modifier = Modifier
        .height(120.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(18.dp))
        .background(color = Color.Gray)){
        Column(modifier = Modifier.fillMaxSize(). padding(8.dp)) {
            Text(text = "Nomor Transaski : ${model.id_trx}", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "Status : Berhasil", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Green)
            Text(text = "Pengeluaran : -${model.nominal}", fontSize = 14.sp, fontWeight = FontWeight.Normal,)
        }
    }
}