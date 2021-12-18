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

    private val mutableLiveData = MutableLiveData<Resource<NewsDomainModel>>()

     fun startNews() {
        viewModelScope.launch {
            newsRepository.requestNews()
                .flowOn(Dispatchers.IO)
                .onStart {
                    mutableLiveData.postValue(Resource.loading(null))
                }
                .catch { e ->
                    mutableLiveData.postValue(Resource.error(e.toString(), null))
                    Log.e("MainActivity", "startNews: $e " )
                }
                .collect{
                    mutableLiveData.postValue(Resource.success(it))
                }
        }
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.requestNews()
        }
    }
}