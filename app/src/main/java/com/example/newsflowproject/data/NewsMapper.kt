package com.example.newsflowproject.data

import com.example.newsflowproject.data.api.NewsResponse
import com.example.newsflowproject.domain.NewsDomainModel

object NewsMapper {
    fun mapResponse(newsResponse: NewsResponse) : List<NewsDomainModel>{
        return newsResponse.articles.map { newsDto ->
            NewsDomainModel(
                author = newsDto.author.orEmpty(),
                title = newsDto.title.orEmpty(),
                description = newsDto.description.orEmpty(),
                url = newsDto.url.orEmpty(),
                urlToImage = newsDto.urlToImage.orEmpty(),
                publishedAt = newsDto.publishedAt.orEmpty()
            )
        } ?: emptyList()
    }
}