package com.techtest.caseone.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.techtest.caseone.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataPreferences(private val context : Context){
        companion object{
            private val USER_SALDO = intPreferencesKey("saldo_user")
        }

    val getSaldoUser:Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[USER_SALDO] ?: 0
    }

    suspend fun editSaldo(token : Int){
        context.dataStore.edit { preferences ->
            preferences[USER_SALDO] = token
        }
    }
}