package com.techtest.caseone.domain.repository

import android.util.Log
import com.techtest.caseone.data.local.DataPreferences
import com.techtest.caseone.data.local.LocalSource
import com.techtest.caseone.domain.model.TransactionEntitiy
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryApp @Inject constructor(
    private val local : LocalSource,
    private val dataStore : DataPreferences
):IRepositoryApp {
    override fun getAllTransaction(): Flow<List<TransactionEntitiy>> {
        return local.getAllTransaction()
    }

    override fun getSuccessTransaction(): Flow<List<TransactionEntitiy>> {
       return local.getSuccessTransaction()
    }

    override suspend fun insertData(value: TransactionEntitiy) {
        Log.d("VIEW model3", "inputData: ")

        local.insertData(value)

    }

    override fun getSaldoUser(): Flow<Int> {
       return dataStore.getSaldoUser
    }

    override suspend fun editSaldo(token: Int) {
        dataStore.editSaldo(token)
    }

}