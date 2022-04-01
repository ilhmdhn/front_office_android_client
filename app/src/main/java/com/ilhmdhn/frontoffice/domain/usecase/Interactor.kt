package com.ilhmdhn.frontoffice.domain.usecase

import com.ilhmdhn.frontoffice.domain.repository.IRepository

class Interactor(private val repository: IRepository): UseCase {
    override fun getLogin(userId: String, userPassword: String) = repository.getLogin(userId, userPassword)

}