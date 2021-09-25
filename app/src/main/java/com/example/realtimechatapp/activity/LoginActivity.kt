package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.Consumer
import com.example.realtimechatapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginBtn.setOnClickListener{
            Toast.makeText(this, "nbvcgh", Toast.LENGTH_SHORT).show()
            val txtEmail: EditText = findViewById(R.id.txtEmail)
        val txtPassword: EditText = findViewById(R.id.txtPassword)
        Amplify.Auth.signIn(
            txtEmail.text.toString(),
            txtPassword.text.toString(),
            { result ->
                if (result.isSignInComplete) {
                    val intent = Intent(this, ChatRoomActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.i("AuthQuickstart", "Sign in not complete")

                }
            },
            { Log.e("AuthQuickstart", "Failed to sign in", it)}
        )
        }
        joinBtn.setOnClickListener{
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
    }

}