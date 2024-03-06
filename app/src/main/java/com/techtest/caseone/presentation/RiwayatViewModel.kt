package com.techtest.caseone.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.techtest.caseone.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RiwayatViewModel @Inject constructor(private val usecase : AppUseCase) : ViewModel() {
   val riwayatList = usecase.getAllTransaction().asLiveData()
}