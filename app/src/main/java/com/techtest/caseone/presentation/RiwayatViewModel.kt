package com.techtest.caseone.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.techtest.caseone.domain.usecase.AppUseCase
import javax.inject.Inject

class RiwayatViewModel @Inject constructor(private val usecase : AppUseCase) : ViewModel() {
   val riwayatList = usecase.getAllTransaction().asLiveData()
}