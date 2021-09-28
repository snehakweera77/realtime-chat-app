package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.core.Amplify
import com.example.realtimechatapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginBtn.setOnClickListener{
            val txtEmail: EditText = findViewById(R.id.txtEmail)
            val txtPassword: EditText = findViewById(R.id.txtPassword)
            Amplify.Auth.signIn(
                txtEmail.text.toString(),
                txtPassword.text.toString(),
                { authSignInResult: AuthSignInResult ->
                    onLoginSuccess(
                        authSignInResult
                    )
                }
            ) { e: AuthException ->
                onLoginError(
                    e
                )
            }
        }
        joinBtn.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    private fun onLoginError(e: AuthException) {
        runOnUiThread {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun onLoginSuccess(authSignInResult: AuthSignInResult) {
        val intent = Intent(this, ChatRoomActivity::class.java)
        startActivity(intent)
    }
}