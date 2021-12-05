package com.example.newsflowproject

import android.app.Application
import com.example.newsflowproject.di.AppComponent
import com.example.newsflowproject.di.AppModule
import com.example.newsflowproject.di.DaggerAppComponent
import com.example.newsflowproject.di.RetrofitModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    private fun setupDi(){
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }
    companion object{
        lateinit var appComponent : AppComponent
    }
}