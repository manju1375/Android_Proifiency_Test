package com.androidtest.samplenewsapp.model.service

import com.androidtest.samplenewsapp.model.CountryNewsModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("s/2iodh4vg0eortkl/facts.json/")
    fun getCountryNews(): Call<CountryNewsModel>
}
