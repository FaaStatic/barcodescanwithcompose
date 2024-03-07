package com.techtest.caseone.presentation

import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.techtest.caseone.data.local.DataPreferences
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InputTransaksiViewModel @Inject constructor(private val usecase:AppUseCase) :ViewModel() {
    suspend fun inputData(value : TransactionEntitiy) {
viewModelScope.launch {
    Log.d("VIEW model", "inputData: ")
    usecase.insertData(value)
}
    }
}