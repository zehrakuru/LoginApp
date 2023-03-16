package com.example.loginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        binding.btnLogin.setOnClickListener {
            val newIntent = Intent(this@MainActivity, SuccessLoginActivity::class.java)
            startActivity(newIntent)
        }

        binding.tvRegister.setOnClickListener {
            val newIntent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(newIntent)
        }
    }
}