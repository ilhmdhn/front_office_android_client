package com.ilhmdhn.frontoffice.core.domain.model

data class DataUserModel(
    val noUser: String,
    val userId: String,
    val lastLogin: String,
    val verifikasi: Int,
    val levelUser: String
)
