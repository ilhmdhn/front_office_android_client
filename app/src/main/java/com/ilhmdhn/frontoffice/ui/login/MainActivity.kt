package com.ilhmdhn.frontoffice.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ilhmdhn.frontoffice.R
import com.ilhmdhn.frontoffice.core.data.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getLogin("AIN", "AI1")

    }

    fun getLogin(userId: String, userPassword: String) {
        loginViewModel.getLogin(userId, userPassword).observe(this, {dataUser ->
            if (dataUser != null){
                when(dataUser){
                    is Resource.Loading -> Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
                    is Resource.Success -> Toast.makeText(this, "Success " + dataUser.data.toString(), Toast.LENGTH_SHORT).show()
                    is Resource.Error -> Toast.makeText(this, "Error "+dataUser.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}