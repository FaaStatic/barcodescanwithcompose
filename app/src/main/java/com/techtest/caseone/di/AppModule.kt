package com.techtest.caseone.di

import com.techtest.caseone.domain.usecase.AppInteractor
import com.techtest.caseone.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun providerViewModelUseCase(interactor : AppInteractor):AppUseCase
}