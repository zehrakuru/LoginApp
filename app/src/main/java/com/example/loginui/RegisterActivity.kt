package com.example.loginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginui.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        fun String.isLongEnough() = length >= 8
        fun String.hasEnoughDigits() = count(Char::isDigit) > 0
        fun String.isMixedCase() = any(Char::isLowerCase) && any(Char::isUpperCase)
        fun String.hasSpecialChar() = any { it in "!,+^" }
        fun String.isEmailValid() = any { it in "@" } && any { it in "." }

        binding.btnRegister.setOnClickListener {

            val email = binding.editTextEmail.text.toString()

            if(!email.isEmailValid()){
                Toast.makeText(this@RegisterActivity, "Email is invalid!", Toast.LENGTH_SHORT).show()
            } else {

                val pwd = binding.textPassword.text.toString()

                if (pwd.isLongEnough() && pwd.hasEnoughDigits() && pwd.isMixedCase() && pwd.hasSpecialChar()) {
                    Toast.makeText(this@RegisterActivity, "Password is valid! Please log into your account.", Toast.LENGTH_SHORT).show()
                    val newIntent = Intent(this@RegisterActivity, MainActivity::class.java)
                    newIntent.putExtra("password", pwd)
                    newIntent.putExtra("email", email)
                    startActivity(newIntent)
                } else {
                    Toast.makeText(this@RegisterActivity, "Password is invalid!", Toast.LENGTH_LONG).show()
                }
            }
        }



    }
}