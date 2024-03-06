package com.techtest.caseone.view.scanning

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.techtest.caseone.data.local.DataPreferences
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.presentation.InputTransaksiViewModel
import com.techtest.caseone.view.scanning.component.AnalyzerType
import com.techtest.caseone.view.scanning.component.BarcodeAnalyzer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScanQRScreen(navCon : NavHostController, viewmodel:InputTransaksiViewModel){
    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
    var cameraStatus by remember {
        mutableStateOf(false)
    }

    if(cameraPermissionState.status.isGranted){
        cameraStatus = true
    }else if(cameraPermissionState.status.shouldShowRationale){
        cameraStatus = false
    }else{
        SideEffect {
            cameraPermissionState.run { launchPermissionRequest() }
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            if (!cameraStatus)
                Text(text = "Please Allow Camera Permission", color = Color.Red, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            if(cameraStatus)
                cameraView(navCon,viewmodel)



        }
    }
}

@Composable
fun cameraView(navcon : NavHostController,viewmodel:InputTransaksiViewModel){
    var isPaused by remember {
        mutableStateOf(false)
    }
    val localContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(localContext)
    }
    
    AndroidView(modifier = Modifier.fillMaxSize(),factory = {
        context ->
        val previewView = PreviewView(context)
        val preview = Preview.Builder().build()
        val selector = CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build()
        preview.setSurfaceProvider(previewView.surfaceProvider)
        val imageAnalysis = ImageAnalysis.Builder().build()
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(context),
            BarcodeAnalyzer(context) {
                isPaused = true
                Log.d("model", it.id_trx?:"")
                CoroutineScope(Dispatchers.IO).launch {
                    viewmodel.inputData(it,context)

                }
navcon.navigate("detailPayment/${it.id_trx}/${it.nama_merchant}/${it.nominal}")




            }

        )

        runCatching {
            if(!isPaused){
                cameraProviderFuture.get().bindToLifecycle(
                    lifecycleOwner,
                    selector,
                    preview,
                    imageAnalysis
                )
            }else{
                cameraProviderFuture.get().unbindAll()
            }

        }.onFailure {
            Log.e("CAMERA", "Camera bind error ${it.localizedMessage}", it)
        }
        previewView
    })
}

@Composable
fun dialogDetailScreen(model : TransactionEntitiy){
    Dialog(onDismissRequest = { /*TODO*/ }, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Red)) {

        }
    }
}