package com.ilhmdhn.frontoffice.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_user")
data class DataUserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "main")
    val main: Int = 1,

    @ColumnInfo(name = "no_user")
    val noUser: String,

    @ColumnInfo(name = "user_id")
    val userId: String,

    @ColumnInfo(name = "last_login")
    val lastLogin: String,

    @ColumnInfo(name = "verifikasi")
    val verifikasi: Int,

    @ColumnInfo(name = "level_user")
    val levelUser: String
)
