package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.User
import com.example.realtimechatapp.R
import kotlinx.android.synthetic.main.activity_email_confirmation.*

class EmailConfirmationActivity : AppCompatActivity() {
    val email : String? = getIntent().getStringExtra("email")
    val password : String? = getIntent().getStringExtra("password")
    val name : String? = getIntent().getStringExtra("name")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_confirmation)
        confirmBtn.setOnClickListener{
            val txtConfirmationCode: EditText = findViewById(R.id.txtConfirmationCode)
            Amplify.Auth.confirmSignUp(
                email!!,
                txtConfirmationCode.text.toString(),
                {result ->
                    reLogin()
                },
                { Log.e("AuthQuickstart", "Failed to sign up", it)}


            )
        }
    }

    private fun reLogin() {
        Amplify.Auth.signIn(
            email,
            password,
            { result ->
                val userId: String = Amplify.Auth.currentUser.userId
                Amplify.DataStore.save(
                    User.builder().name(name).build(),
                    {_ ->
                        val intent = Intent(this, ChatRoomActivity::class.java)
                        startActivity(intent)
                    },
                    { Log.e("AuthQuickstart", "Failed to sign in", it)}

                )

            },
            { Log.e("AuthQuickstart", "Failed to sign in", it)}

        )
    }
}