package com.ilhmdhn.frontoffice.data

import com.ilhmdhn.frontoffice.data.source.local.LocalDataSource
import com.ilhmdhn.frontoffice.data.source.remote.RemoteDataSource
import com.ilhmdhn.frontoffice.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.domain.repository.IRepository
import com.ilhmdhn.frontoffice.utils.AppExecutors

class Repository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors): IRepository {

    override fun getLogin(userId: String, userPassword: String): LoginResponse {
        return remoteDataSource.getLogin(userId, userPassword)
    }

}