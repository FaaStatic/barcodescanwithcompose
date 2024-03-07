package com.techtest.caseone.domain.usecase

import android.util.Log
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.repository.IRepositoryApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInteractor @Inject constructor(private val repoTouris : IRepositoryApp) : AppUseCase{
    override fun getAllTransaction(): Flow<List<TransactionEntitiy>> {
        return repoTouris.getAllTransaction()
    }

    override fun getSuccessTransaction(): Flow<List<TransactionEntitiy>> {
        return repoTouris.getSuccessTransaction()
    }

    override suspend fun insertData(value: TransactionEntitiy) {
        Log.d("VIEW model2", "inputData: ")
        repoTouris.insertData(value)

    }

    override fun getSaldoUser(): Flow<Int> {
      return repoTouris.getSaldoUser()
    }

    override suspend fun editSaldo(token: Int) {
        repoTouris.editSaldo(token)
    }

}