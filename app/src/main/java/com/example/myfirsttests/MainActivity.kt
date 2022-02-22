package com.example.myfirsttests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfirsttests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            emailInput.addTextChangedListener(emailValidator)
            passwordInput.addTextChangedListener(passwordValidator)

            saveButton.setOnClickListener {
                if (emailValidator.isValidEmail){
                    Toast.makeText(this@MainActivity, getString(R.string.valid_email), Toast.LENGTH_SHORT).show()
                }else{
                    val errorEmail = getString(R.string.invalid_email)
                    emailInput.error = errorEmail
                    Toast.makeText(this@MainActivity, errorEmail, Toast.LENGTH_SHORT).show()
                }
                if (passwordValidator.isValidPassword){
                    Toast.makeText(this@MainActivity, getString(R.string.valid_password), Toast.LENGTH_SHORT).show()
                }else{
                    val errorPassword = getString(R.string.invalid_password)
                    passwordInput.error = errorPassword
                    Toast.makeText(this@MainActivity, errorPassword, Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}