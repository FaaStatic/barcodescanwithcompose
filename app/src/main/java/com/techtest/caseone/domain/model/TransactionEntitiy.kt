package com.techtest.caseone.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "transaction_table")
data class TransactionEntitiy(
    @PrimaryKey
    @ColumnInfo(name = "id_transaksi")
    var id_trx:Int? = 0,
    @ColumnInfo(name = "nama_merchant")
    var nama_merchant:String? = null,
    @ColumnInfo(name = "bank_merchant")
    var bank_merchant:String? = null,
    @ColumnInfo(name = "nominal")
    var nominal : Int? = 0,
    @ColumnInfo(name = "status_transaksi")
    var status_transaksi : Int? = 0,
    @ColumnInfo(name = "tanggal_transaksi")
    var tanggal_transaksi : String? = null,
    )

