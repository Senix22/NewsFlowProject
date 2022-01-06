package com.example.newsflowproject.data

import com.example.newsflowproject.data.api.NewsApi
import com.example.newsflowproject.domain.NewsDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map


class NewsRepository constructor(
    private val api: NewsApi,
    private val newsMapper: NewsResponseMapper
) {
    suspend fun requestNews(): Flow<List<NewsDomainModel>> =
        flow {
            emit(newsMapper.mapResponse(api.getNews()))
        }
}