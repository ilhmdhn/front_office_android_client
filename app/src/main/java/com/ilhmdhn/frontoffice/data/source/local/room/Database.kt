package com.ilhmdhn.frontoffice.data.source.local.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

abstract class Database: RoomDatabase() {
    abstract fun ihpDao(): Dao
}