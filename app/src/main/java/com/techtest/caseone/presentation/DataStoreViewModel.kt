package com.techtest.caseone.presentation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(private val usecase : AppUseCase):ViewModel() {
    fun getData() = usecase.getSaldoUser()

    suspend fun updateData(value : Int){
        viewModelScope.launch {
            usecase.editSaldo(value)
        }
    }
}