package com.ilhmdhn.frontoffice.di

import com.ilhmdhn.frontoffice.core.domain.usecase.IhpInteractor
import com.ilhmdhn.frontoffice.core.domain.usecase.IhpUseCase
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
    abstract fun provideIhpUseCase(IhpInteractor: IhpInteractor): IhpUseCase
}