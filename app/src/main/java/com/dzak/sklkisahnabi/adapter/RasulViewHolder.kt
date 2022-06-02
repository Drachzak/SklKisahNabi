package com.dzak.sklkisahnabi.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzak.sklkisahnabi.databinding.ItemRecyclerNabiBinding
import com.dzak.sklkisahnabi.databinding.ItemRecyclerRasulBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem

class RasulViewHolder (val rasulbinding : ItemRecyclerRasulBinding) : RecyclerView.ViewHolder(rasulbinding.root) {
    fun bindView(rasulitem: KisahNabiItem) {
        itemView.run {
            rasulbinding.txtNamarasul.text = rasulitem.nama
            Glide.with(this).load(rasulitem.avatar).into(rasulbinding.imgRasul)
        }
    }
}

