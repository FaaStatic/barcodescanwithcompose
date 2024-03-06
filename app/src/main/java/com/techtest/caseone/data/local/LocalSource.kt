package com.techtest.caseone.data.local

import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.dao.AppDAO
import com.techtest.caseone.domain.localsource.LocalSourceInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSource @Inject constructor(private val daoApp : AppDAO) : LocalSourceInterface {
    override fun getAllTransaction(): Flow<List<TransactionEntitiy>> {
        return daoApp.getAllTransaksi()
    }

    override fun getSuccessTransaction(): Flow<List<TransactionEntitiy>> {
        return daoApp.getSuccessTransaksi()
    }

    override suspend fun insertData(value: TransactionEntitiy) {
       daoApp.insertTransaction(value)
    }

}