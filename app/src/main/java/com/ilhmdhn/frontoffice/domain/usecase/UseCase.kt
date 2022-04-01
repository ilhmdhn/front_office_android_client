package com.ilhmdhn.frontoffice.domain.usecase

import com.ilhmdhn.frontoffice.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.data.source.remote.response.LoginResponse

interface UseCase {
    fun getLogin(userId: String, userPassword: String): LoginResponse
}