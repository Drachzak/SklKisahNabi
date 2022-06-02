package com.dzak.sklkisahnabi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.sklkisahnabi.databinding.ItemRecyclerNabiBinding
import com.dzak.sklkisahnabi.databinding.ItemRecyclerRasulBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem

class AdapterRasul : RecyclerView.Adapter<RasulViewHolder>() {

    private var listrasuliten = arrayListOf<KisahNabiItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(itemsnabi: List<KisahNabiItem>) {
        listrasuliten.clear()
        listrasuliten.addAll(itemsnabi)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RasulViewHolder {
        val bindingitemrasul =
            ItemRecyclerRasulBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RasulViewHolder(bindingitemrasul)
    }

    override fun onBindViewHolder(holder: RasulViewHolder, position: Int) {
        val data = listrasuliten[position]
        holder.bindView(data)
    }

    override fun getItemCount(): Int {
        return listrasuliten.size
    }
}