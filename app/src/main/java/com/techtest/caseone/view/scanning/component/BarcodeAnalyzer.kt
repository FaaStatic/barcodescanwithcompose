package com.techtest.caseone.view.scanning.component

import android.annotation.SuppressLint
import android.content.Context
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import com.techtest.caseone.domain.model.TransactionEntitiy
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BarcodeAnalyzer(private val ctx : Context, private val callBack : (data : TransactionEntitiy)-> Unit) : ImageAnalysis.Analyzer{

    private val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
        .build()
    private val scanner = BarcodeScanning.getClient(options)
    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProx: ImageProxy) {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm")
        imageProx.image?.let {image ->
            scanner.process(
                InputImage.fromMediaImage(
                    image, imageProx.imageInfo.rotationDegrees
                )
            ).addOnSuccessListener { result -> result.takeIf { it.isNotEmpty() }?.mapNotNull {
                it.rawValue
            }?.joinToString(",").let {
                val dataString = it?.split(".")
                 dataString?.let { it1 ->
                   val result =  TransactionEntitiy(
                        id_trx = it1.elementAt(1),
                        bank_merchant = it1.elementAt(0),
                        nama_merchant = it1.elementAt(2),
                        nominal = Integer.parseInt(it1.elementAt(3)),
                        status_transaksi = 1,
                        tanggal_transaksi = LocalDateTime.now().format(formatter)

                    )
                    callBack(result)
                }

            }  }.addOnCompleteListener {
                imageProx.close()
            }
        }
    }

}