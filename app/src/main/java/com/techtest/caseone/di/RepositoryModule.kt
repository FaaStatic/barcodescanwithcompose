package com.techtest.caseone.di

import com.techtest.caseone.data.local.DataPreferences
import com.techtest.caseone.domain.repository.IRepositoryApp
import com.techtest.caseone.domain.repository.RepositoryApp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, DataStoreModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
     @Binds
     abstract fun providerAppRepository(repository : RepositoryApp ):IRepositoryApp
}