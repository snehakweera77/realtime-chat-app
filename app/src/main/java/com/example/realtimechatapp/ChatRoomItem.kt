package com.example.realtimechatapp

import android.widget.ImageView

data class ChatRoomItem(var userId:String = "", val userImage: ImageView, val userName: String, val msgTime: String, val userMsg: String, val newMsgs: String)
