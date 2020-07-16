package com.androidtest.samplenewsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.androidtest.samplenewsapp.model.ApiRepo
import com.androidtest.samplenewsapp.model.NewsApiResponse

class MainActivityViewModel(private val mApiRepo: ApiRepo) : ViewModel() {

    private var news: LiveData<NewsApiResponse>? = null

    fun getNewsData(refresh: Boolean): LiveData<NewsApiResponse> {
        if (refresh) {
            news = null
        }
        if (this.news == null) {
            news = mApiRepo.getNewsPosts()
            return news as LiveData<NewsApiResponse>
        }
        return news as LiveData<NewsApiResponse>
    }
}