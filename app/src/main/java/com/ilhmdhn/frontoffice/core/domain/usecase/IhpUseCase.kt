package com.ilhmdhn.frontoffice.core.domain.usecase

import com.ilhmdhn.frontoffice.core.data.Resource
import com.ilhmdhn.frontoffice.core.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.core.domain.model.DataUserModel
import kotlinx.coroutines.flow.Flow

interface IhpUseCase {
    fun getLogin(userId: String, userPassword: String): Flow<Resource<DataUserModel>>
}