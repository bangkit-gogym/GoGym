package com.bangkit.gogym

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.gogym.data.response.EquipmentItem
import com.bumptech.glide.Glide

class EquipmentAdapter(private val listEquipmet: List<EquipmentItem>) : RecyclerView.Adapter<EquipmentAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_item_title)
        val ivImage: ImageView = view.findViewById(R.id.iv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_equipment, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = listEquipmet[position].name

        val imageUrl = listEquipmet[position].photoUrl
        Glide.with(holder.ivImage)
            .load(imageUrl)
            .into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        return listEquipmet.size
    }

}