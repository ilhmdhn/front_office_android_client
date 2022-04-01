package com.ilhmdhn.frontoffice.data.source.remote.network

import com.ilhmdhn.frontoffice.data.source.remote.response.LoginResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("login")
    fun getLogin(
        @Query("user_id") userId: String = "",
        @Query("user_password") userPassword: String = ""
    ): LoginResponse
}