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
                val name = binding.editTextName.text.toString()
                val username = binding.editTextUsername.text.toString()

                if (pwd.isLongEnough() && pwd.hasEnoughDigits() && pwd.isMixedCase() && pwd.hasSpecialChar()) {
                    Toast.makeText(this@RegisterActivity, "Password is valid!", Toast.LENGTH_SHORT).show()
                    val newIntent = Intent(this@RegisterActivity, FormActivity::class.java)
                    newIntent.putExtra("name", name)
                    //newIntent.putExtra("email", email)
                    newIntent.putExtra("username", username)
                    startActivity(newIntent)
                } else {
                    Toast.makeText(this@RegisterActivity, "Password is invalid!", Toast.LENGTH_LONG).show()
                }
            }
        }



    }
}