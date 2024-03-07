package com.techtest.caseone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techtest.caseone.domain.model.TransactionEntitiy
import com.techtest.caseone.domain.dao.AppDAO

@Database(
    entities = [TransactionEntitiy::class],
    version = 1,
)
abstract class AppDB : RoomDatabase(){
    abstract fun PrimaryDAO(): AppDAO
}