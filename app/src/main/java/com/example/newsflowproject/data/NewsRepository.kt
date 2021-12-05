package com.example.newsflowproject.data

import com.example.newsflowproject.data.api.NewsApi
import com.example.newsflowproject.domain.NewsDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class NewsRepository constructor(private val api: NewsApi) {
    fun requestNews(): Flow<List<NewsDomainModel>> =
        flow {
            api.getNews()
                .map(NewsMapper::mapResponse)
        }
}