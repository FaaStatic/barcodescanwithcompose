package com.techtest.caseone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techtest.caseone.util.nav.BottomNavigationViewMenu
import com.techtest.caseone.ui.theme.QrcodescannerTheme
import com.techtest.caseone.view.HomeScreen
import com.techtest.caseone.view.PembayaranScreen
import com.techtest.caseone.view.RiwayatScreen
import com.techtest.caseone.view.ScanQRScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QrcodescannerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    MyApp()
                }
                // A surface container using the 'background' color from the theme
            }

        }
    }
}

@Composable
fun MyApp(){
    val navControl = rememberNavController()
        Scaffold (
            bottomBar = { BottomNavigationViewMenu(navControl = navControl)},
        ){
            Column (
                modifier = Modifier.padding(it)
            ) {
                 NavHost(navController = navControl, startDestination = "home", builder ={
                     composable(route = "home"){
                         HomeScreen(navCon = navControl )
                     }
                     composable(route = "history"){
                         PembayaranScreen(navCon = navControl)
                     }
                     composable(route = "scanqr"){
                         ScanQRScreen(navCon = navControl)
                     }
                     composable(route = "payment"){
                         RiwayatScreen(navCon = navControl)
                     }
                 } )
            }
        }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    QrcodescannerTheme {
        MyApp()
    }
}