package com.example.newsflowproject.di

import android.content.Context
import androidx.room.Room
import com.example.newsflowproject.data.NewsRepository
import com.example.newsflowproject.data.NewsResponseMapper
import com.example.newsflowproject.data.api.NewsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {

    @Provides
    fun provideContext() = appContext

    @Singleton
    @Provides
    fun provideNewsRepository(newsApi: NewsApi, mapper: NewsResponseMapper): NewsRepository {
        return NewsRepository(newsApi, mapper)
    }
}