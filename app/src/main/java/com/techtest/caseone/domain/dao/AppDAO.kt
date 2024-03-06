package com.techtest.caseone.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techtest.caseone.domain.model.TransactionEntitiy
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDAO {
    @Query("SELECT * FROM 'transaction_table' ORDER BY 'id_transaksi' ASC")
    fun getAllTransaksi() : Flow<List<TransactionEntitiy>>

    @Query("SELECT * FROM 'transaction_table' WHERE 'status_transaksi == 1' ORDER BY 'id_transaksi' ASC ")
    fun getSuccessTransaksi() : Flow<List<TransactionEntitiy>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(value : TransactionEntitiy)

}