package com.example.newsflowproject.domain

import com.example.newsflowproject.data.api.NewsApi
import javax.inject.Inject


data class NewsDomainModel(
    val author : String,
    val title : String,
    val description : String,
    val url : String,
    val urlToImage : String,
    val publishedAt : String
)