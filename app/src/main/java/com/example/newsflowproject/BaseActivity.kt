package com.example.newsflowproject

import androidx.activity.ComponentActivity
import com.example.newsflowproject.di.AppComponent

abstract class BaseActivity : ComponentActivity() {
    val appComponent : AppComponent
    get() = App.appComponent
}