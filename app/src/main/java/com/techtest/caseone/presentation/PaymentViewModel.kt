package com.techtest.caseone.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.techtest.caseone.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PaymentViewModel @Inject constructor(private val usecase : AppUseCase):ViewModel() {
    val paymentSuccess = usecase.getSuccessTransaction().asLiveData(viewModelScope.coroutineContext)
}