package com.ilhmdhn.frontoffice.data.source.remote.response

data class LoginResponse(
	val data: DataLogin,
	val state: Boolean? = false,
	val message: String? = ""
)

data class DataLogin(
	val noUser: String? = "",
	val userId: String? = "",
	val lastLogin: String? = "",
	val verifikasi: Int? = 0,
	val levelUser: String? = ""
)