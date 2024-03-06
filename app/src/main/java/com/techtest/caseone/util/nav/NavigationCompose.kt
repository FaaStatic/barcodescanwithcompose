package com.techtest.caseone.util.nav

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

import com.techtest.caseone.R
val dataMap = listOf<BottomNavItem>(
    BottomNavItem("history", R.drawable.ic_history, "Transaction History"),
    BottomNavItem("scanqr", R.drawable.ic_qr, "Scan Barcode"),
    BottomNavItem("payment", R.drawable.ic_bill, "Payment History"),
)
@Composable
fun BottomNavigationViewMenu(navControl : NavController){
    val navBack by navControl.currentBackStackEntryAsState()
    val currentRoute = navBack?.destination?.route
    Box(modifier = Modifier.fillMaxWidth()){
        NavigationBar(modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )) {
            dataMap.map {
                NavigationBarItem(selected = currentRoute == it.route, onClick = { navControl.navigate(it.route) {
                    popUpTo(navControl.graph.findStartDestination().id) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                } }, icon = { Image(painter = painterResource(id = it.icon), modifier = Modifier
                    .width(24.dp)
                    .height(24.dp), contentDescription = it.label, contentScale = ContentScale.Fit)



                }, label = { Text(text = it.label)})
            }
        }
    }




}