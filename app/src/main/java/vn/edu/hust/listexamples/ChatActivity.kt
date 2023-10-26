package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val messages = arrayListOf<ChatModel>()
        messages.add(ChatModel("me", "Xin chao", R.drawable.thumb1))
        messages.add(ChatModel("friend", "Chao ban", R.drawable.thumb2))
        messages.add(ChatModel("me", "Ban hoc truong nao?", R.drawable.thumb1))
        messages.add(ChatModel("friend", "HUST", R.drawable.thumb2))


        findViewById<ListView>(R.id.list_view).adapter = ChatAdapter(messages)
    }
}