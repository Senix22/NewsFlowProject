package com.example.newsflowproject.domain.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsflowproject.domain.NewsViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(newsViewModel : Provider<NewsViewModel>) : ViewModelProvider.Factory {
    private val provider = mapOf<Class<*>, Provider<out ViewModel>>(
        NewsViewModel::class.java to newsViewModel
    )
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return provider[modelClass]?.get() as T
    }

}