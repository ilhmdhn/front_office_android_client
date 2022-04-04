package com.ilhmdhn.frontoffice.core.domain.repository

import com.ilhmdhn.frontoffice.core.data.Resource
import com.ilhmdhn.frontoffice.core.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.core.domain.model.DataUserModel
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getLogin(userId: String, userPassword: String): Flow<Resource<DataUserModel>>
}