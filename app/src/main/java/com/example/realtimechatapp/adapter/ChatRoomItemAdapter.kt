package com.example.realtimechatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.realtimechatapp.R
import com.example.realtimechatapp.activity.ChatScreenActivity
import com.example.realtimechatapp.model.ChatRoomItem
import kotlinx.android.synthetic.main.chat_room_item.*


class ChatRoomItemAdapter(private var context: Context, private var userList: ArrayList<ChatRoomItem>) : RecyclerView.Adapter<ChatRoomItemAdapter.MyHolder>() {
    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val newMsgs: TextView = view.findViewById(R.id.newMsgs)
        val userImage: ImageView = view.findViewById(R.id.userImageCRI)
        val userName: TextView = view.findViewById(R.id.userNameCRI)
        val msgTime: TextView = view.findViewById(R.id.msgTimeCRI)
        val userMsg: TextView = view.findViewById(R.id.userMsgCRI)
        val userLayout: LinearLayout = view.findViewById(R.id.userLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_room_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.userName
        holder.userMsg.text = user.userMsg
        holder.msgTime.text = user.msgTime
        /*if (user.newMsgs != null)
            holder.newMsgs.text = user.newMsgs
        else
            holder.newMsgs.visibility = View.INVISIBLE*/
        //Glide.with(context).load(user.userImage).placeholder(R.drawable.dummy_img).into(holder.userImage)
        Glide.with(context).load(R.drawable.dummy_img).placeholder(R.drawable.dummy_img).into(holder.userImage)

        /*holder.userLayout.setOnClickListener {
            val intent = Intent(context,ChatActivity::class.java)
            intent.putExtra("userId",user.userId)
            intent.putExtra("userName",user.userName)
            context.startActivity(intent)
        }*/
        holder.userLayout.setOnClickListener {
            val intent = Intent(context, ChatScreenActivity::class.java)
            intent.putExtra("userId",user.userId)
            intent.putExtra("userName",user.userName)
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return userList.size
    }
}