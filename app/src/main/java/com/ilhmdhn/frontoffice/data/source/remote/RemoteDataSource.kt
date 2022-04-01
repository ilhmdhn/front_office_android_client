package com.ilhmdhn.frontoffice.data.source.remote

import android.util.Log
import com.ilhmdhn.frontoffice.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.data.source.remote.network.ApiService
import com.ilhmdhn.frontoffice.data.source.remote.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {

    fun getLogin(userId: String, userPassword: String): LoginResponse {
//        try {
              return apiService.getLogin(userId, userPassword)
//            } catch (e: Exception){
//                Log.e("error", e.toString())
//            }
        }
}