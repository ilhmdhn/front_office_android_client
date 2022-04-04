package com.ilhmdhn.frontoffice.core.utils

import com.ilhmdhn.frontoffice.core.data.source.local.entity.DataUserEntity
import com.ilhmdhn.frontoffice.core.data.source.remote.response.DataLogin
import com.ilhmdhn.frontoffice.core.domain.model.DataUserModel

object DataMapper {
    
    fun mapUserResponseToEntity(input: DataLogin): DataUserEntity{
        return with(input){
            DataUserEntity(
                1, noUser, userId, lastLogin, verifikasi, levelUser
            )
        }
    }

    fun mapUserEntityToDomain(input: DataUserEntity?): DataUserModel{
        return with(input){
            DataUserModel(
                this?.noUser ?: "", this?.userId ?: "",
                this?.lastLogin ?: "" ,
                this?.verifikasi ?: 0,
                this?.levelUser ?: ""
            )
        }
    }
}
