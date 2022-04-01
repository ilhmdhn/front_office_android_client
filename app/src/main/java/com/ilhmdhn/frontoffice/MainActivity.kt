package com.ilhmdhn.frontoffice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ilhmdhn.frontoffice.ui.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getLogin("AIN", "AI1")

    }

    fun getLogin(userId: String, userPassword: String) {
        val dataLogin = loginViewModel.getLogin("AIN", "AI1")
        Toast.makeText(this, dataLogin.toString(), Toast.LENGTH_LONG).show()
//        dataLogin
    }
}