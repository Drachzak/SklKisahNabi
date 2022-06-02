package com.dzak.sklkisahnabi.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.dzak.sklkisahnabi.databinding.ItemRecyclerNabiBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem

class NabiViewHolder(val nabibinding : ItemRecyclerNabiBinding) : RecyclerView.ViewHolder(nabibinding.root) {
        fun bindView(nabiitem : KisahNabiItem) {
            itemView.run {
                nabibinding.txtNamanabi.text = nabiitem.nama
                Glide.with(this).load(nabiitem.avatar).into(nabibinding.imgAvatarnabi)
//                nabibinding.imgAvatarnabi.load(nabiitem.avatar)

            }
        }
}
