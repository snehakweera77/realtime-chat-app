package com.example.realtimechatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val userList = ArrayList<ChatRoomItem>()
        userList.add("1",
            "https://notjustdev-dummy.s3.us-east-2.amazonaws.com/avatars/vadim.jpg", "Vadim", "2020-10-03T14:48:00.000Z",
            "btw, SpaceX is interested in buying notJust.dev!", "3")
        val userAdapter = ChatRoomItemAdapter(this@MainActivity, userList)
        chatRV.adapter = userAdapter*/
    }
}