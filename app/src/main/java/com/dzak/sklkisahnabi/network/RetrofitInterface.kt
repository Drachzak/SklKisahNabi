package com.dzak.sklkisahnabi.network

import com.dzak.sklkisahnabi.model.KisahNabiItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("v1/nabi")
    fun getDataNabi() : Call<List<KisahNabiItem>>

    @GET("v1/rasul")
    fun getDataRasul() : Call<List<KisahNabiItem>>

}