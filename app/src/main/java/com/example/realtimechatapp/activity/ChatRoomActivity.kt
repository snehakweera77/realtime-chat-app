package com.example.realtimechatapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realtimechatapp.R
import com.example.realtimechatapp.adapter.ChatRoomItemAdapter
import com.example.realtimechatapp.model.ChatRoomItem
import kotlinx.android.synthetic.main.activity_chat_room.*

class ChatRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
        chatRV.setHasFixedSize(true)
        chatRV.setItemViewCacheSize(13)
        chatRV.layoutManager = LinearLayoutManager(this)
        val userList = ArrayList<ChatRoomItem>()
        userList.add(
            ChatRoomItem("1",
                "https://notjustdev-dummy.s3.us-east-2.amazonaws.com/avatars/vadim.jpg", "Vadim", "2020-10-03T14:48:00.000Z",
                "btw, SpaceX is interested in buying notJust.dev!", "1")
        )
        userList.add(
            ChatRoomItem("1",
                "https://notjustdev-dummy.s3.us-east-2.amazonaws.com/avatars/vadim.jpg", "Vadim", "2020-10-03T14:48:00.000Z",
                "btw, SpaceX is interested in buying notJust.dev!")
        )
        userList.add(
            ChatRoomItem("1",
                "https://notjustdev-dummy.s3.us-east-2.amazonaws.com/avatars/vadim.jpg", "Vadim", "2020-10-03T14:48:00.000Z",
                "btw, SpaceX is interested in buying notJust.dev!", "3")
        )
        userList.add(
            ChatRoomItem("1",
                "https://notjustdev-dummy.s3.us-east-2.amazonaws.com/avatars/vadim.jpg", "Vadim", "2020-10-03T14:48:00.000Z",
                "btw, SpaceX is interested in buying notJust.dev!", "3")
        )
        userList.add(
            ChatRoomItem("1",
                "https://notjustdev-dummy.s3.us-east-2.amazonaws.com/avatars/vadim.jpg", "Vadim", "2020-10-03T14:48:00.000Z",
                "btw, SpaceX is interested in buying notJust.dev!", "3")
        )
        val userAdapter = ChatRoomItemAdapter(this, userList)
        chatRV.adapter = userAdapter

    }
}