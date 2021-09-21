package com.example.realtimechatapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realtimechatapp.R
import kotlinx.android.synthetic.main.activity_chat_screen.*

class ChatScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_screen)
        chatScreenRV.layoutManager = LinearLayoutManager(this)

        var intent = getIntent()
        var userId = intent.getStringExtra("userId")
        var userName = intent.getStringExtra("userName")


        imgBack.setOnClickListener {
            onBackPressed()
        }

    }
}