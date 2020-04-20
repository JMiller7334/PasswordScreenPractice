package com.example.passwordscreenpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int){
        login(1),
        password(2),
        success(0)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idEnterPassword)
        val txtPassword = findViewById<TextView>(R.id.idEnterPassword)
        val btnLogin = findViewById<Button>(R.id.idButtonLogin)

        btnLogin.setOnClickListener {
            when (checkLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                LoginSuccess.login -> {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.errMsgLogin),
                        Toast.LENGTH_LONG
                    ).show()
                    txtLogin.requestFocus()

                }
                LoginSuccess.password -> {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.errMsgPassword),
                        Toast.LENGTH_LONG
                    ).show()
                    txtPassword.requestFocus()

                }

                else ->
                    Toast.makeText(
                        applicationContext,
                        "success!",
                        Toast.LENGTH_LONG
                    ).show()
            }
        }
    }
    fun checkLogin(attemptLogin: String, attemptPassword: String): LoginSuccess {
        val holdLogin = "jacob"
        val holdPassword = "password"

        if (attemptLogin != holdLogin) {
            return LoginSuccess.login
        }
        return if (attemptPassword != holdPassword) {
            return LoginSuccess.password
        } else LoginSuccess.success
    }
}
