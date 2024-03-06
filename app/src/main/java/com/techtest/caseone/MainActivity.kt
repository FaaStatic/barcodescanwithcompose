package com.techtest.caseone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.presentation.InputTransaksiViewModel
import com.techtest.caseone.presentation.PaymentViewModel
import com.techtest.caseone.presentation.RiwayatViewModel
import com.techtest.caseone.util.nav.BottomNavigationViewMenu
import com.techtest.caseone.ui.theme.QrcodescannerTheme
import com.techtest.caseone.view.home.HomeScreen
import com.techtest.caseone.view.payment.PembayaranScreen
import com.techtest.caseone.view.history.RiwayatScreen
import com.techtest.caseone.view.payment.detailPaymentScreen
import com.techtest.caseone.view.scanning.ScanQRScreen
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
        ){ it ->
        Column (
                modifier = Modifier.padding(it)
            ) {
                 NavHost(navController = navControl, startDestination = "home", builder ={
                     composable(route = "home"){
                         HomeScreen(navCon = navControl )
                     }
                     composable(route = "history"){
                         val viewModel = hiltViewModel<PaymentViewModel>()
                         PembayaranScreen(navCon = navControl,viewModel)
                     }
                     composable(route = "scanqr"){
                         val viewModel = hiltViewModel<InputTransaksiViewModel>()
                         ScanQRScreen(navCon = navControl,viewModel)
                     }
                     composable(route = "payment"){
                         val viewModel = hiltViewModel<RiwayatViewModel>()
                         RiwayatScreen(navCon = navControl, viewModel)
                     }
                     composable(route = "detailPayment/{id}/{merchant}/{nominal}",  arguments = listOf(
                         navArgument("nominal") {
                             type = NavType.IntType
                             defaultValue = 0
                         },
                         navArgument("merchant") {
                             type = NavType.StringType
                             nullable = true
                         },
                         navArgument("id") {
                             type = NavType.StringType
                             nullable = true
                         },

                     ) ){
                         val id = it.arguments?.getString("id")
                         val merchant = it.arguments?.getString("merchant")
                         val nominal = it.arguments?.getInt("nominal")

                        detailPaymentScreen(navcon = navControl, model = TransactionEntitiy(
                            id_trx = id,
                            nama_merchant = merchant,
                            nominal = nominal
                        )  )
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