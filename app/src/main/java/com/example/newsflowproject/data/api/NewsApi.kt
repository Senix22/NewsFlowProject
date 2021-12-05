package com.example.newsflowproject.data.api

import retrofit2.http.GET

interface NewsApi {

    @GET("/v2/everything?q=tesla&from=2021-11-03&sortBy=publishedAt&apiKey=435149dee83241479ddd0c3c8672cef9")
     suspend fun getNews() : List<NewsResponse>
}