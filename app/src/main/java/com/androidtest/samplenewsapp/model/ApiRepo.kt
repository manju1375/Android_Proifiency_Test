package com.androidtest.samplenewsapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidtest.samplenewsapp.model.service.ApiClient
import com.androidtest.samplenewsapp.model.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepo {

    var endpoints: ApiClient = ApiClient()

    fun getNewsPosts(): LiveData<NewsApiResponse> {
        val apiResponse = MutableLiveData<NewsApiResponse>()
        val apiService = endpoints.getClient()!!.create(ApiInterface::class.java)
        val call: Call<CountryNewsModel> = apiService.getCountryNews()
        call.enqueue(object : Callback<CountryNewsModel> {
            override fun onFailure(call: Call<CountryNewsModel>?, t: Throwable?) {
                apiResponse.postValue(NewsApiResponse(t!!))
            }

            override fun onResponse(call: Call<CountryNewsModel>?, response: Response<CountryNewsModel>?) {
                if (response!!.isSuccessful) {
                    apiResponse.postValue(NewsApiResponse(response.body()!!))
                } else {
                    apiResponse.postValue(NewsApiResponse(response.code()))
                }
            }

        })

        return apiResponse
    }
}