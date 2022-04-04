package com.ilhmdhn.frontoffice.core.data.source.remote

import android.util.Log
import com.ilhmdhn.frontoffice.core.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.core.data.source.remote.network.ApiService
import com.ilhmdhn.frontoffice.core.data.source.remote.response.DataLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getLogin(userId: String, userPassword: String): Flow<ApiResponse<DataLogin>> {
        return flow {
            try {
                val response = apiService.getLogin(userId, userPassword)
                if (response.state == true){
                    emit(ApiResponse.Success(response.data))
                }else{
                    emit(ApiResponse.Error(response.message.toString()))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}