package com.example.newsflowproject.domain


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflowproject.data.NewsRepository
import com.example.newsflowproject.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val mutableLiveData = MutableLiveData<Resource<List<NewsDomainModel>>>()

    fun startNews() {
        viewModelScope.launch {
            newsRepository.requestNews()
                .onStart {
                    mutableLiveData.postValue(Resource.loading(null))
                }
                .map {
                    Resource.success(it)
                }
                .catch { e ->
                    mutableLiveData.postValue(Resource.error(e.toString(), null))
                    Log.e("MainActivity", "startNews: $e ")
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    mutableLiveData.postValue(it)
                }

        }
    }

}