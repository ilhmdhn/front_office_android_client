package com.ilhmdhn.frontoffice.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ilhmdhn.frontoffice.core.data.Resource
import com.ilhmdhn.frontoffice.core.data.source.remote.response.DataLogin
import com.ilhmdhn.frontoffice.core.data.source.remote.response.LoginResponse
import com.ilhmdhn.frontoffice.core.domain.model.DataUserModel
import com.ilhmdhn.frontoffice.core.domain.usecase.IhpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val ihpUseCase: IhpUseCase): ViewModel(){
     fun getLogin(userId: String, userPassword: String): LiveData<Resource<DataUserModel>> {
        return ihpUseCase.getLogin(userId, userPassword).asLiveData()
    }
}