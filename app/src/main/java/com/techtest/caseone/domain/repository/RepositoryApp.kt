package com.techtest.caseone.domain.repository

import com.techtest.caseone.data.local.LocalSource
import com.techtest.caseone.domain.model.TransactionEntitiy
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryApp @Inject constructor(
    private val local : LocalSource
):IRepositoryApp {
    override fun getAllTransaction(): Flow<List<TransactionEntitiy>> {
        return local.getAllTransaction()
    }

    override fun getSuccessTransaction(): Flow<List<TransactionEntitiy>> {
       return local.getSuccessTransaction()
    }

    override suspend fun insertData(value: TransactionEntitiy) {
        local.insertData(value)
    }

}