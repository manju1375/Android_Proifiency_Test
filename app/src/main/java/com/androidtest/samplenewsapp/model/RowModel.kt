package com.androidtest.samplenewsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RowModel {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("imageHref")
    @Expose
    var imageHref: Any? = null

}