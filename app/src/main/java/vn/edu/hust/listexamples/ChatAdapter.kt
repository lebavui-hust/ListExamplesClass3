package vn.edu.hust.listexamples

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(val messages: ArrayList<ChatModel>): BaseAdapter() {
    override fun getCount(): Int {
        return messages.size
    }

    override fun getItem(position: Int): Any {
        return messages[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        if (messages[position].username.equals("me"))
            return 1
        else
            return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        if (getItemViewType(position) == 0)
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item_left, parent, false)
        else
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item_right, parent, false)

        itemView.findViewById<TextView>(R.id.text_message).text = messages[position].message
        itemView.findViewById<ImageView>(R.id.image_avatar).setImageResource(messages[position].avatar)

        return itemView
    }
}