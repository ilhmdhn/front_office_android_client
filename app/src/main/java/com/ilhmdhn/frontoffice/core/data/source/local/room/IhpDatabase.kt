package com.ilhmdhn.frontoffice.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilhmdhn.frontoffice.core.data.source.local.entity.DataUserEntity

@Database(entities = [DataUserEntity::class], version = 2, exportSchema = false)
abstract class IhpDatabase: RoomDatabase() {
    abstract fun ihpDao(): IhpDao
}