package com.techtest.caseone.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InputTransaksiViewModel @Inject constructor(private val usecase:AppUseCase) :ViewModel() {
    suspend fun inputData(value : TransactionEntitiy) {
        viewModelScope.launch (Dispatchers.IO){
            usecase.insertData(value)
        }
    }
}