package com.example.newsflowproject.di

import android.content.Context
import com.example.newsflowproject.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class ,RetrofitModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}