package com.example.loginui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginui.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")

        binding.textName.setText(name)
        //binding.textEmail.setText(email)
        binding.textUsername.setText(username)
    }
}