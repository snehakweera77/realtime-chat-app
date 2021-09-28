package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSignUpResult
import com.amplifyframework.core.Amplify
import com.example.realtimechatapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpBtn.setOnClickListener{
            val txtEmail: EditText = findViewById(R.id.txtEmail)
            val txtPassword: EditText = findViewById(R.id.txtPassword)
            Amplify.Auth.signUp(
                txtEmail.text.toString(),
                txtPassword.text.toString(),
                AuthSignUpOptions.builder().userAttribute(
                    AuthUserAttributeKey.email(), txtEmail.text.toString()
                ).build(),
                { authSignUpResult: AuthSignUpResult ->
                    onJoinSuccess(
                        authSignUpResult
                    )
                }
            ) { e: AuthException ->
                onJoinError(
                    e
                )
            }

        }
    }
    private fun onJoinSuccess(authSignUpResult: AuthSignUpResult) {
        val intent = Intent(this, EmailConfirmationActivity::class.java)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val txtName = findViewById<EditText>(R.id.txtName)
        intent.putExtra("email", txtEmail.text.toString())
        intent.putExtra("password", txtPassword.text.toString())
        intent.putExtra("name", txtName.text.toString())
        startActivity(intent)
    }

    private fun onJoinError(e: AuthException) {
        runOnUiThread {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG)
                .show()
        }
    }
}