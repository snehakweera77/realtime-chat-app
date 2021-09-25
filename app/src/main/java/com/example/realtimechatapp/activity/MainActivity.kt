package com.example.realtimechatapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.amplifyframework.auth.AuthUser
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.example.realtimechatapp.R
import com.example.realtimechatapp.adapter.ChatRoomItemAdapter
import com.example.realtimechatapp.model.ChatRoomItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_room_item.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentUser = Amplify.Auth.currentUser
        val intent: Intent
        if (currentUser == null) {
            intent = Intent(applicationContext, LoginActivity::class.java)
        }
        else {
            intent = Intent(applicationContext, ChatRoomActivity::class.java)

        }
        startActivity(intent)
        finish()
    }
}
