package com.bangkit.gogym.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.gogym.MainActivity
import com.bangkit.gogym.databinding.ActivityOnBoardingTwoBinding

class OnBoardingTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            var intent = Intent(this@OnBoardingTwoActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}