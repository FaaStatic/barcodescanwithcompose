package com.techtest.caseone.domain.usecase

import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.repository.IRepositoryApp
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
       repoTouris.insertData(value)
    }

}