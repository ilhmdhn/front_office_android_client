package com.ilhmdhn.frontoffice.core.data.source.remote.network

import com.ilhmdhn.frontoffice.core.data.source.remote.response.LoginResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/login")
    suspend fun getLogin(
        @Query("user_id") userId: String = "AIN",
        @Query("user_password") userPassword: String = "AI1"
    ):LoginResponse
}