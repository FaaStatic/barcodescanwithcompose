package com.techtest.caseone.domain.localsource

import com.techtest.caseone.domain.model.TransactionEntitiy
import kotlinx.coroutines.flow.Flow

interface LocalSourceInterface {
    fun getAllTransaction():Flow<List<TransactionEntitiy>>
    fun getSuccessTransaction():Flow<List<TransactionEntitiy>>
    suspend fun insertData(value : TransactionEntitiy)

}