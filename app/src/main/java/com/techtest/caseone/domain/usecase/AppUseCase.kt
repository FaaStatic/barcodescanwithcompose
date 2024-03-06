package com.techtest.caseone.domain.usecase

import com.techtest.caseone.domain.model.TransactionEntitiy
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getAllTransaction(): Flow<List<TransactionEntitiy>>
    fun getSuccessTransaction(): Flow<List<TransactionEntitiy>>
    suspend fun insertData(value : TransactionEntitiy)
}