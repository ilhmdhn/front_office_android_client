package com.ilhmdhn.frontoffice.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
	@field:SerializedName("data")
	val data: DataLogin,
	@field:SerializedName("state")
	val state: Boolean? = false,
	@field:SerializedName("message")
	val message: String? = ""
)

data class DataLogin(
	@field:SerializedName("no_user")
	val noUser: String,
	@field:SerializedName("user_id")
	val userId: String,
	@field:SerializedName("Last_Login")
	val lastLogin: String,
	@field:SerializedName("Verifikasi")
	val verifikasi: Int,
	@field:SerializedName("level_user")
	val levelUser: String
)