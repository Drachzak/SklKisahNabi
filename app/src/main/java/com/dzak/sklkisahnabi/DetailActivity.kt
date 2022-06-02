package com.dzak.sklkisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dzak.sklkisahnabi.databinding.ActivityDetailBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    companion object {
        const val Detail_Data = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KisahNabiItem>(Detail_Data)

        binding.tvNamaDetailNabi.text = data?.nama
        binding.tvUsia.text = data?.usia
        binding.tvDetaildesk.text = data?.deskripsi
        binding.tvTpKelahiran.text = data?.tpKelahiran
        binding.tvTpTinggal.text = data?.tempat
        Glide.with(this).load(data?.avatar).into(binding.imgDetailnabi)
    }
}