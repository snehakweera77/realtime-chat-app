package com.example.realtimechatapp.model

data class ChatRoomItem(var userId:String, val userImage: String, val userName: String, val msgTime: String, val userMsg: String, val newMsgs: String = "")
