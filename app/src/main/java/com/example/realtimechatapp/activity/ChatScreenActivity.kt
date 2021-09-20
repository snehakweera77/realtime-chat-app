package com.example.realtimechatapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realtimechatapp.R

class ChatScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_screen)
        //chatScreenRV.layoutManager = LinearLayoutManager(this, Lin.VERTICAL, false)

    }
}