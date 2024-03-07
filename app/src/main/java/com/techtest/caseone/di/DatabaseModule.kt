package com.techtest.caseone.di

import android.content.Context
import androidx.room.Room
import com.techtest.caseone.data.local.AppDB
import com.techtest.caseone.domain.dao.AppDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun createDatabaseProvider(
        @ApplicationContext ctx: Context,
    ): AppDB {
        return Room.databaseBuilder(
            ctx,
            AppDB::class.java,
            "app_db.db"
        ).build()
    }

    @Provides
    fun provideAppDAO(db : AppDB) = db.PrimaryDAO()
}