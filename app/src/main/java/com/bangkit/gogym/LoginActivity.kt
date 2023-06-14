package com.bangkit.gogym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bangkit.gogym.data.response.LoginResult
import com.bangkit.gogym.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var loginResult: LoginResult


        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        binding.tvRegisternow.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
            val email = binding.etEmail.text.toString()
            val pw = binding.etPassword.text.toString()

            authenticate(email, pw)
        }

        viewModel.loginUser.observe(this) { response ->
            if (response?.error == false) {
                loginResult = response!!.data
                Log.d("LOGINACTIVITY", "onCreate: ${loginResult.token}")
                // then save user session and go to home page
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

    }

    private fun authenticate(email: String, pw: String) {
        viewModel.loginUser(email, pw)
    }
}