package com.example.loginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        //for email validation
        fun String.isEmailValid() = any { it in "@" } && any { it in "." }

        binding.btnRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            if(!email.isEmailValid()){
                Toast.makeText(this@MainActivity, "Email is invalid!", Toast.LENGTH_SHORT).show()
            }
            else{
                val newIntent = Intent(this@MainActivity, SuccessLoginActivity::class.java)
                startActivity(newIntent)
            }
        }



        binding.tvRegister.setOnClickListener {
            val newIntent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(newIntent)
        }
    }
}