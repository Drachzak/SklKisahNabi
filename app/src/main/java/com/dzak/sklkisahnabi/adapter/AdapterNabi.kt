package com.dzak.sklkisahnabi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.sklkisahnabi.DetailActivity
import com.dzak.sklkisahnabi.databinding.ItemRecyclerNabiBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem

class AdapterNabi : RecyclerView.Adapter<NabiViewHolder>(){

    private var listnabiitem = arrayListOf<KisahNabiItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(itemsnabi : List<KisahNabiItem>){
        listnabiitem.clear()
        listnabiitem.addAll(itemsnabi)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NabiViewHolder {
        val bindingitemnabi = ItemRecyclerNabiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NabiViewHolder(bindingitemnabi)
    }

    override fun onBindViewHolder(holder: NabiViewHolder, position: Int) {
        val data = listnabiitem[position]
        holder.bindView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.Detail_Data, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listnabiitem.size
    }

}