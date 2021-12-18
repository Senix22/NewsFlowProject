package com.example.newsflowproject.data


import com.example.newsflowproject.data.api.NewsResponse
import com.example.newsflowproject.domain.NewsDomainModel
import javax.inject.Inject

class NewsResponseMapper @Inject constructor() {
    fun mapResponse(newsResponse: NewsResponse): List<NewsDomainModel> {
        return newsResponse.articles?.map { newsItem ->
            NewsDomainModel(
                author = newsItem.author.orEmpty(),
                title = newsItem.title.orEmpty(),
                description = newsItem.description.orEmpty(),
                url = newsItem.url.orEmpty(),
                urlToImage = newsItem.urlToImage.orEmpty(),
                publishedAt = newsItem.publishedAt.orEmpty()
            )
        } ?: emptyList()
    }
}