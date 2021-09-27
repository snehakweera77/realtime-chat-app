package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.realtimechatapp.R
import kotlinx.android.synthetic.main.activity_email_confirmation.*
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.Model
import com.amplifyframework.datastore.DataStoreException
import com.amplifyframework.datastore.DataStoreItemChange
import com.amplifyframework.datastore.generated.model.User

class EmailConfirmationActivity : AppCompatActivity() {
    private val email : String? = getIntent().getStringExtra("email")
    private val password : String? = getIntent().getStringExtra("password")
    val name : String? = getIntent().getStringExtra("name")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_confirmation)
        confirmBtn.setOnClickListener{
            val txtConfirmationCode: EditText = findViewById(R.id.txtConfirmationCode)
            Amplify.Auth.confirmSignUp(
                email!!,
                txtConfirmationCode.text.toString(),
                {reLogin() },
                { Log.e("AuthQuickstart", "Failed to sign up", it)}


            )
        }
    }

    private fun reLogin() {
        Amplify.Auth.signIn(
            email,
            password,
            { val id: String = Amplify.Auth.currentUser.userId
                Amplify.DataStore.save(
                    User.builder().name(name).id(id).build(),
                    this::onSavedSuccess,
                    this::onError
                )

            },
            { Log.e("AuthQuickstart", "Failed to sign in", it)}

        )
    }
    private fun <T : Model?> onSavedSuccess(tDataStoreItemChange: DataStoreItemChange<T>) {
        val intent = Intent(this, ChatRoomActivity::class.java)
        startActivity(intent)
    }

    private fun onError(e: DataStoreException) {
        runOnUiThread {
            Toast
                .makeText(applicationContext, e.message, Toast.LENGTH_LONG)
                .show()
        }
    }
}