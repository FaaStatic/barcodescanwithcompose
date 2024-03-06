package com.techtest.caseone.domain.repository

import com.techtest.caseone.domain.model.TransactionEntitiy
import kotlinx.coroutines.flow.Flow

interface IRepositoryApp {
    fun getAllTransaction(): Flow<List<TransactionEntitiy>>
    fun getSuccessTransaction(): Flow<List<TransactionEntitiy>>
    suspend fun insertData(value : TransactionEntitiy)
}