package com.androidtest.samplenewsapp.model

class NewsApiResponse {

    var posts: CountryNewsModel? = null
    var error: Throwable? = null
    var code : Int? = null

    constructor(posts: CountryNewsModel) {
        this.posts = posts
        this.error = null
    }

    constructor(error: Throwable) {
        this.error = error
        this.posts = null
    }

    constructor(code : Int){
        this.code = code
    }
}