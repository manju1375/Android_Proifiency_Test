package com.androidtest.samplenewsapp

import com.androidtest.samplenewsapp.model.service.ApiInterface
import com.androidtest.samplenewsapp.viewmodel.MainActivityViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    lateinit var mainActivityModel: MainActivityViewModel
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun api_isWorking() {
        // call the api
        val api = ApiInterface.create("https://dl.dropboxusercontent.com/")
        val response = api.getCountryNews()
        // verify the response is OK
        assertEquals(response.isExecuted,false)
    }


}
