package com.ilhmdhn.frontoffice.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.ilhmdhn.frontoffice.core.data.Resource
import com.ilhmdhn.frontoffice.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()

    private var _binding: FragmentLoginBinding? = null
    private val binding get()= _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            if (username.isEmpty()){
                binding.etUsername.error="Masukkan Username"
            } else if(password.isEmpty()){
                binding.etPassword.error = "Masukkan Password"
            }else{
            getLogin(username, password)
            }
        }
    }

    fun getLogin(userId: String, userPassword: String) {
        loginViewModel.getLogin(userId, userPassword).observe(viewLifecycleOwner, {dataUser ->
            if (dataUser != null){
                when(dataUser){
                    is Resource.Loading -> Toast.makeText(context, "loading", Toast.LENGTH_SHORT).show()
                    is Resource.Success -> Toast.makeText(context, "Success " + dataUser.data.toString(), Toast.LENGTH_LONG).show()
                    is Resource.Error -> Toast.makeText(context, "Error "+dataUser.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}