package com.ilhmdhn.frontoffice.core.data

import com.ilhmdhn.frontoffice.core.data.source.local.LocalDataSource
import com.ilhmdhn.frontoffice.core.data.source.remote.RemoteDataSource
import com.ilhmdhn.frontoffice.core.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.core.data.source.remote.response.DataLogin
import com.ilhmdhn.frontoffice.core.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.core.domain.model.DataUserModel
import com.ilhmdhn.frontoffice.core.domain.repository.IRepository
import com.ilhmdhn.frontoffice.core.utils.AppExecutors
import com.ilhmdhn.frontoffice.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IhpRepository @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors): IRepository {
    override fun getLogin(userId: String, userPassword: String): Flow<Resource<DataUserModel>> {
        return object : NetworkBoundResource<DataUserModel, DataLogin>(){
            override fun loadFromDB(): Flow<DataUserModel> {
                return localDataSource.getUser().map {
                    DataMapper.mapUserEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: DataUserModel?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<DataLogin>> {
                return remoteDataSource.getLogin(userId, userPassword)
            }

            override suspend fun saveCallResult(data: DataLogin) {
                val dataUser = DataMapper.mapUserResponseToEntity(data)
                localDataSource.insertUser(dataUser)
            }
        }.asFlow()
    }
}