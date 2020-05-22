package com.example.movieapp

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val colors: List<String>) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val textView = TextView(parent.context)
        textView.textSize = 24f
        textView.setPadding(32,12,32,12)
        return ListViewHolder(textView)
    }
    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(colors.get(position))
    }
}

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(color: String) {
        (itemView as TextView).text = color
    }
}