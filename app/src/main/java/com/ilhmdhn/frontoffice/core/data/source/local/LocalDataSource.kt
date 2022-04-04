package com.ilhmdhn.frontoffice.core.data.source.local

import com.ilhmdhn.frontoffice.core.data.source.local.entity.DataUserEntity
import com.ilhmdhn.frontoffice.core.data.source.local.room.IhpDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val dao: IhpDao) {

    fun getUser(): Flow<DataUserEntity> {
        return dao.getUser()
    }

    suspend fun deleteUser() = dao.deleteUser()

    suspend fun insertUser(user: DataUserEntity) = dao.insertUser(user)
}