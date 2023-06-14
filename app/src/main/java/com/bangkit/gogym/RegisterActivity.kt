package com.bangkit.gogym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bangkit.gogym.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailReg.text.toString()
            val name = binding.etNameReg.text.toString()
            val pw = binding.etPasswordReg.text.toString()

            register(email, name, pw)
        }

        viewModel.registerUser.observe(this) { response ->
            if (response?.error == false) {
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun register(email: String, name: String, pw: String) {
        viewModel.registerUser(name, email, pw)
    }

}