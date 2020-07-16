package com.androidtest.samplenewsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CountryNewsModel {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("rows")
    @Expose
    //val rows: List<RowModel>? = null
    val  rows: MutableList<RowModel>? = mutableListOf()

}