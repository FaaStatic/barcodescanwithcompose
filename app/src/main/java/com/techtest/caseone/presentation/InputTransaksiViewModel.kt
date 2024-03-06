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
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InputTransaksiViewModel @Inject constructor(private val usecase:AppUseCase) :ViewModel() {
    suspend fun inputData(value : TransactionEntitiy, ctx : Context) {
        val dataStore = DataPreferences(context = ctx)
        val result = dataStore.getSaldoUser.asLiveData().value
        Log.d("ACDC", result.toString())
        val total = result?.minus(value.nominal!!)
        if (total != null) {
            dataStore.editSaldo(total)
        }
        viewModelScope.launch (Dispatchers.IO){

            usecase.insertData(value)
        }
    }
}