package com.example.newsflowproject

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.newsflowproject.App.Companion.appComponent
import com.example.newsflowproject.di.AppComponent
import com.example.newsflowproject.domain.NewsDomainModel



class MainActivity : BaseActivity() {

    private val news : NewsDomainModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsListItem(
                NewsDomainModel(
                    author = news?.author,
                    title = news?.title,
                    news?.description,
                    news?.url,
                    news?.urlToImage,
                    news?.publishedAt
                )
            )
        }
        appComponent.inject(this)

    }

    override fun onStart() {
        super.onStart()
//        lifecycleScope.launchWhenCreated {
//
//        }
    }
}
