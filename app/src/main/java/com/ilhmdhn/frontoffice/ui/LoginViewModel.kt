package com.ilhmdhn.frontoffice.ui

import androidx.lifecycle.ViewModel
import com.ilhmdhn.frontoffice.data.source.remote.network.ApiResponse
import com.ilhmdhn.frontoffice.data.source.remote.network.ApiService
import com.ilhmdhn.frontoffice.data.source.remote.response.DataLogin
import com.ilhmdhn.frontoffice.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.domain.usecase.UseCase

class LoginViewModel(private val useCase: UseCase): ViewModel(){
     fun getLogin(userId: String, userPassword: String): LoginResponse {
//         return useCase.getLogin(userId, userPassword)
         return LoginResponse(
             DataLogin(
                 "","","",1,""
             ),
             true,
             "berhasil"
         )
    }
}