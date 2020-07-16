package com.androidtest.samplenewsapp.model.di

import com.androidtest.samplenewsapp.model.ApiRepo
import com.androidtest.samplenewsapp.viewmodel.MainActivityViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    // single instance of HelloRepository
    single { ApiRepo() }

    // MyViewModel ViewModel
    viewModel{ MainActivityViewModel(get()) }
}