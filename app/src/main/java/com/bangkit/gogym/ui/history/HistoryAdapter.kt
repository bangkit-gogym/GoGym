package com.bangkit.gogym.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.gogym.R
import com.bangkit.gogym.data.response.HistoryItem
import com.bumptech.glide.Glide

class HistoryAdapter(private val listHistory: List<HistoryItem>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_history_name)
        val tvDate: TextView = view.findViewById(R.id.tv_history_date)
        val ivImage: ImageView = view.findViewById(R.id.iv_history)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cleanDate = listHistory[position].date.take(10)
        holder.tvName.text = listHistory[position].name
        holder.tvDate.text = cleanDate

        val imageUrl = listHistory[position].photoUrl
        Glide.with(holder.ivImage)
            .load(imageUrl)
            .into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }

}