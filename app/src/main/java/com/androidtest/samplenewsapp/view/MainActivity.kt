package com.androidtest.samplenewsapp.view

import android.annotation.SuppressLint
import androidx.lifecycle.Observer
import android.os.Bundle

import com.androidtest.samplenewsapp.viewmodel.MainActivityViewModel
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.util.Log.i
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager


import com.johncodeos.pulltorefreshexample.NewsAdapter
import com.androidtest.samplenewsapp.R
import com.androidtest.samplenewsapp.model.CountryNewsModel
import com.androidtest.samplenewsapp.model.RowModel
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.layout_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    private val viewModel: MainActivityViewModel by viewModel()
    var itemsCells: List<RowModel>? = null
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        supportActionBar?.title = resources.getString(R.string.loading_quote)
        getData(false)
        setRVLayoutManager()
    }

    @SuppressLint("SetTextI18n")
    private fun getData(refresh: Boolean) {
        viewModel.getNewsData(refresh).observe(this, Observer {
            if (it == null) {
                logInfo("Handle Error")
            }
            if (it?.error == null) {
                if (it?.code == null) {
                    val quote: CountryNewsModel? = it!!.posts
                    supportActionBar?.title = quote?.title
                    itemsCells = quote?.rows
                    setAdapter()
                } else {
                    supportActionBar?.title = resources.getString(R.string.error_in_loading)
                    when (it.code!!) {
                        404 -> toast("Sorry not found! :(")
                        else -> {
                            toast("Error! Please try again..")
                        }
                    }
                }
            } else {
                supportActionBar?.title = resources.getString(R.string.error_in_loading)
                val e: Throwable = it.error!!
                logInfo("Error is " + e.message)
            }
        })
    }

    private fun logInfo(msg: String) {
        i("MainActivity", msg)
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    private fun setAdapter() {
        adapter = NewsAdapter(itemsCells)
        adapter.setHasStableIds(true)
        adapter.notifyDataSetChanged()
        itemsrv.adapter = adapter
    }

    private fun setRVLayoutManager() {
        val mLayoutManager = LinearLayoutManager(itemsrv.context)
        //**Shows the latest item of the RecyclerView first.
        mLayoutManager.reverseLayout = true
        mLayoutManager.stackFromEnd = true
        //**
        itemsrv.layoutManager = mLayoutManager
        itemsrv.setHasFixedSize(true)
    }
}