package com.dzak.sklkisahnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.dzak.sklkisahnabi.adapter.AdapterNabi
import com.dzak.sklkisahnabi.databinding.FragmentNabiBinding
import com.dzak.sklkisahnabi.model.KisahNabiItem
import com.dzak.sklkisahnabi.network.RetrofitInterface
import com.dzak.sklkisahnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NabiFragment : Fragment() {

    private lateinit var binding: FragmentNabiBinding
    private lateinit var adapterNabi: AdapterNabi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNabiBinding.inflate(inflater, container, false)

        adapterNabi = AdapterNabi()
        binding.rvNabi.layoutManager = GridLayoutManager(context, 2)
        binding.rvNabi.setHasFixedSize(true)
        binding.rvNabi.adapter = adapterNabi

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitservice = RetrofitService.getService().getDataNabi()
        retrofitservice.enqueue(object : Callback<List<KisahNabiItem>> {
            override fun onResponse(
                call: Call<List<KisahNabiItem>>,
                response: Response<List<KisahNabiItem>>
            ) {
                val list = response.body()!!
                list.let {
                    it.let { it1 -> adapterNabi.addData(it1) }
                }
            }

            override fun onFailure(call: Call<List<KisahNabiItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}
