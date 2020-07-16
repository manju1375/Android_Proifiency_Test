package com.androidtest.samplenewsapp.model.service

import com.androidtest.samplenewsapp.model.CountryNewsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiInterface {
    @GET("s/2iodh4vg0eortkl/facts.json/")
    fun getCountryNews(): Call<CountryNewsModel>

    // factory methods
    companion object {
        fun create(baseUrl: String): ApiInterface {
            // here we set the base url of our API
            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    // add the JSON dependency so we can handle json APIs
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            // here we pass a reference to our API interface
            // and get back a concrete instance
            return retrofit.create(ApiInterface::class.java)
        }
    }
}
