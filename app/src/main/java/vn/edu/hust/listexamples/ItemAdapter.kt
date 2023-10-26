package vn.edu.hust.listexamples

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val itemView: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item, parent, false)

            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.imageThumb.setImageResource(items[position].imageThumb)
        viewHolder.textCaption.text = items[position].caption
        viewHolder.checkSelected.isChecked = items[position].selected

        viewHolder.checkSelected.setOnClickListener {
            items[position].selected = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        val imageThumb: ImageView
        val textCaption: TextView
        val checkSelected: CheckBox
        init {
            textCaption = itemView.findViewById(R.id.text_caption)
            imageThumb = itemView.findViewById(R.id.image_thumb)
            checkSelected = itemView.findViewById(R.id.check_selected)
        }
    }
}