package com.ilhmdhn.frontoffice.core.di

import com.ilhmdhn.frontoffice.core.data.IhpRepository
import com.ilhmdhn.frontoffice.core.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(ihpRepository: IhpRepository): IRepository
}