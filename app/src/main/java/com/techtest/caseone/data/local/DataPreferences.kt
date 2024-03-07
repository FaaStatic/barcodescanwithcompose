package com.techtest.caseone.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class  DataPreferences @Inject constructor(private val dataStore: DataStore<Preferences>){
        companion object{
            private val USER_SALDO = intPreferencesKey("saldo_user")
        }

    val getSaldoUser:Flow<Int> = dataStore.data.map { preferences ->
        preferences[USER_SALDO] ?: 0
    }

    suspend fun editSaldo(token : Int){
        dataStore.edit { preferences ->
            preferences[USER_SALDO] = token
        }

    }
}