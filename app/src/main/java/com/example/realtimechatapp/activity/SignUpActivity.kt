package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
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
            val attrs = mapOf(
                AuthUserAttributeKey.email() to txtEmail.text.toString()
            )
            val options = AuthSignUpOptions.builder()
                .userAttributes(attrs.map { AuthUserAttribute(it.key, it.value) })
                .build()
            Amplify.Auth.signUp(
                txtEmail.text.toString(),
                txtPassword.text.toString(),
                options,
                { result ->
                    val intent = Intent(this, EmailConfirmationActivity::class.java)
                    val txtEmail: EditText = findViewById(R.id.txtEmail)
                    val txtPassword: EditText = findViewById(R.id.txtPassword)
                    val txtName : EditText = findViewById(R.id.txtName)
                    intent.putExtra("email", txtEmail.text.toString())
                    intent.putExtra("password", txtPassword.text.toString())
                    intent.putExtra("name", txtName.text.toString())
                    startActivity(intent)

                },
                { Log.e("AuthQuickstart", "Failed to sign in", it)}
            )
        }
    }
}