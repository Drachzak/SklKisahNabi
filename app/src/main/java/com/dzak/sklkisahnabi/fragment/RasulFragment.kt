package com.dzak.sklkisahnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.sklkisahnabi.R
import com.dzak.sklkisahnabi.adapter.AdapterRasul
import com.dzak.sklkisahnabi.databinding.FragmentRasulBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem
import com.dzak.sklkisahnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RasulFragment : Fragment() {

    private lateinit var binding: FragmentRasulBinding
    private lateinit var adapterRasul: AdapterRasul

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRasulBinding.inflate(inflater,container,false)
        binding.rvRasul.setHasFixedSize(true)
        adapterRasul = AdapterRasul()
        binding.rvRasul.layoutManager = LinearLayoutManager(context)
        binding.rvRasul.adapter = adapterRasul
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitservice = RetrofitService.getService().getDataRasul()
        retrofitservice.enqueue(object : Callback<List<KisahNabiItem>>{
            override fun onResponse(
                call: Call<List<KisahNabiItem>>,
                response: Response<List<KisahNabiItem>>
            ) {
                val list = response.body()!!
                list.let {
                    it.let { it1 -> adapterRasul.addData(it1) }
            }


            }

            override fun onFailure(call: Call<List<KisahNabiItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}