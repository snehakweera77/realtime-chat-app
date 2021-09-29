package com.example.realtimechatapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.generated.model.ChatRoom
import com.amplifyframework.datastore.generated.model.ChatRoomUser
import com.example.realtimechatapp.R
import com.example.realtimechatapp.adapter.ChatRoomItemAdapter
import com.example.realtimechatapp.model.ChatRoomItem
import kotlinx.android.synthetic.main.activity_chat_room.*

class ChatRoomActivity : AppCompatActivity() {
    private val chatRoomsList = ArrayList<ChatRoom>()
    private val userAdapter = ChatRoomItemAdapter(this, chatRoomsList)
    private val currentUser = Amplify.Auth.currentUser;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
        chatRV.setHasFixedSize(true)
        chatRV.setItemViewCacheSize(13)
        chatRV.layoutManager = LinearLayoutManager(this)


        /*userList.add(
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
        )*/
        chatRV.adapter = userAdapter
        getChatRooms()
        Amplify.DataStore.observe(
            ChatRoomUser::class.java,
            {   //queryTodoList()
                Log.i("Amplify-observer", "Observation began.")
            },
            {
                getChatRooms()
                Log.i("Amplify-observer", "syncCloud-> " + it.item().toString())
            },
            { Log.e("Amplify-observer", "Observation failed.", it) },
            {
                Log.i("Amplify-observer", "Observation complete.")
            })
    }


    private fun getChatRooms() {
        Amplify.DataStore.query(
            ChatRoomUser::class.java,
            Where.matches(ChatRoomUser.USER.eq(currentUser.userId)),
            {chatRoomsUsers -> runOnUiThread {
                while (chatRoomsUsers.hasNext()) {
                    chatRoomsList.add(chatRoomsUsers.next().chatRoom)
                    userAdapter.notifyDataSetChanged()
                }
            } },
            { Log.e("TAG", "Could not query DataStore", it) }
        )
    }


}

