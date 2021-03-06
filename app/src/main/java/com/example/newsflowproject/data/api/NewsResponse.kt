package com.example.newsflowproject.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsResponse(@SerializedName("articles") val articles: List<NewsDto>?)

data class NewsDto(
    @SerializedName("sources") val sources: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("urlToImage") val urlToImage: String?,
    @SerializedName("publishedAt") val publishedAt: String?
) : NewsEventResponse()

sealed class NewsEventResponse