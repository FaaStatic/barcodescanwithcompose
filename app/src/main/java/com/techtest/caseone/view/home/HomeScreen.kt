package com.techtest.caseone.view.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techtest.caseone.data.local.DataPreferences
import com.techtest.caseone.presentation.DataStoreViewModel
import kotlin.coroutines.coroutineContext

@Composable
fun HomeScreen(navCon : NavHostController, viewModel : DataStoreViewModel){
    val saldo = viewModel.getData().collectAsState(initial = 0)
    var saldoUtama by remember{ mutableIntStateOf(0) }
    LaunchedEffect(Unit){
        Log.d("saldonya", saldo.value.toString())
        if(saldo.value == 0){
            Log.d("kucing", "Masuk")
            viewModel.updateData(5000000)
            saldoUtama = saldo.value ?: 0
        }else{
            saldoUtama = saldo.value ?: 0
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)) {
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)

                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Blue,
                            Color.Cyan,
                            Color.White
                        ),
                        start = Offset(0f, 0f),

                        ),
                    shape = RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomEnd = 8.dp,
                        bottomStart = 8.dp
                    )
                )){
                Column(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()) {

                    Text(text = "Saldo User : ${saldoUtama}", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White )
                }
            }

        }
    }
}

