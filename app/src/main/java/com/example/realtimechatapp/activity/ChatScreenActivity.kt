package com.example.realtimechatapp.activity

import ChatAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realtimechatapp.R
import com.example.realtimechatapp.model.Chat
import kotlinx.android.synthetic.main.activity_chat_screen.*

class ChatScreenActivity : AppCompatActivity() {
    var myId: String? = null
    var chatList = ArrayList<Chat>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_screen)
        chatScreenRV.layoutManager = LinearLayoutManager(this)

        var intent = getIntent()
        var userId = intent.getStringExtra("userId")
        var userName = intent.getStringExtra("userName")

        tvUserName.text = userName

        imgBack.setOnClickListener {
            onBackPressed()
        }
        sendMsgBtn.setOnClickListener {
            var message: String = editMsg.text.toString()

            if (message.isEmpty()) {
                Toast.makeText(applicationContext, "message is empty", Toast.LENGTH_SHORT).show()
                editMsg.setText("")
            } else {
                sendMessage(myId!!, userId!!, message)
                editMsg.setText("")
            }
        }

        readMessage(myId!!, userId!!)
    }

    private fun sendMessage(senderId: String, receiverId: String, message: String) {
        var temp = Chat(senderId, receiverId, message)
        chatList.add(temp)

    }
    fun readMessage(senderId: String, receiverId: String) {
        val chatAdapter = ChatAdapter(this, chatList)
        chatScreenRV.adapter = chatAdapter
    }
}