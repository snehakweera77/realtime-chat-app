package com.example.realtimechatapp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.generated.model.ChatRoom
import com.amplifyframework.datastore.generated.model.ChatRoomUser
import com.amplifyframework.datastore.generated.model.Message
import com.amplifyframework.datastore.generated.model.User
import com.bumptech.glide.Glide
import com.example.realtimechatapp.R
import com.example.realtimechatapp.activity.ChatScreenActivity

class ChatRoomItemAdapter(private var context: Context, private var chatRoomUserList: ArrayList<ChatRoom>) : RecyclerView.Adapter<ChatRoomItemAdapter.MyHolder>() {
    private lateinit var message:Message
    private lateinit var user:User
    private val currentUser = Amplify.Auth.currentUser

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val newMsgs: TextView = view.findViewById(R.id.newMsgs)
        val userImage: ImageView = view.findViewById(R.id.userImageCRI)
        val userName: TextView = view.findViewById(R.id.userNameCRI)
        val msgTime: TextView = view.findViewById(R.id.msgTimeCRI)
        val userMsg: TextView = view.findViewById(R.id.userMsgCRI)
        val userLayout: LinearLayout = view.findViewById(R.id.userLayout)
        val newMsgs: TextView = view.findViewById(R.id.newMsgs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_room_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val chatRoomUser = chatRoomUserList[position]
        Amplify.DataStore.query(
            ChatRoomUser::class.java,
            Where.matches(ChatRoomUser.CHATROOM.eq(chatRoomUser.id)),
            {chatRoomsUsers -> runOnUiThread {
                while (chatRoomsUsers.hasNext()) {
                    if (chatRoomsUsers.next().user.toString() != currentUser.userId)
                        user = chatRoomsUsers.next().user
                }
            } },
            { Log.e("TAG", "Could not query DataStore", it) }
        )
        if (chatRoomUser.lastMessage != null) {
            Amplify.DataStore.query(
                Message::class.java,
                Where.matches(Message.ID.eq(chatRoomUser.lastMessage.id)),
                {lastMsg ->
                    while (lastMsg.hasNext()) {
                        message = lastMsg.next()
                    }
                },
                { Log.e("TAG", "Could not query DataStore", it) }
            )
        }

        holder.userName.text = user.name
        holder.userMsg.text = message.content
        holder.msgTime.text = message.createdAt.toString()
        if (chatRoomUser.newMsgs != 0)
            holder.newMsgs.text = chatRoomUser.newMsgs.toString()
        else
            holder.newMsgs.visibility = View.INVISIBLE
        Glide.with(context).load(user.imageUrl).placeholder(R.drawable.ic_default_user).into(holder.userImage)

        /*holder.userLayout.setOnClickListener {
            val intent = Intent(context,ChatActivity::class.java)
            intent.putExtra("userId",user.userId)
            intent.putExtra("userName",user.userName)
            context.startActivity(intent)
        }*/
        holder.userLayout.setOnClickListener {
            val intent = Intent(context, ChatScreenActivity::class.java)
            intent.putExtra("userId",chatRoomUser.id)
            intent.putExtra("userName",user.name)
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return chatRoomUserList.size
    }
}