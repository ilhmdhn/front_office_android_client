package com.ilhmdhn.frontoffice.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ilhmdhn.frontoffice.core.data.source.local.entity.DataUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IhpDao {
    @Query("SELECT * FROM data_user WHERE main = 1")
    fun getUser(): Flow<DataUserEntity>

    @Query("DELETE FROM data_user WHERE main = 1")
    suspend fun deleteUser()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: DataUserEntity)
}