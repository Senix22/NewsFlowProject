package com.example.newsflowproject.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines?sources=bbc-news&apiKey=435149dee83241479ddd0c3c8672cef9")
     suspend fun getNews() : NewsResponse
}