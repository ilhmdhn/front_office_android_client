package com.ilhmdhn.frontoffice.core.domain.usecase

import com.ilhmdhn.frontoffice.core.data.Resource
import com.ilhmdhn.frontoffice.core.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IhpInteractor @Inject constructor(private val repository: IRepository): IhpUseCase {
    override fun getLogin(userId: String, userPassword: String) = repository.getLogin(userId, userPassword)
}