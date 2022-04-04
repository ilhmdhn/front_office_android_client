package com.ilhmdhn.frontoffice.core.di

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.ilhmdhn.frontoffice.core.data.source.local.room.IhpDao
import com.ilhmdhn.frontoffice.core.data.source.local.room.IhpDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): IhpDatabase = Room.databaseBuilder(
        context,
        IhpDatabase::class.java, "Ihp.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: IhpDatabase): IhpDao = database.ihpDao()
}