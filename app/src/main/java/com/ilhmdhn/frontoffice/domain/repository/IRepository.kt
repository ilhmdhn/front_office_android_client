package com.ilhmdhn.frontoffice.domain.repository

import com.ilhmdhn.frontoffice.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.data.source.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getLogin(userId: String, userPassword: String): LoginResponse
}