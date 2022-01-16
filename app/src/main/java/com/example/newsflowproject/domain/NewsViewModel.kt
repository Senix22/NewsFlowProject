package com.example.newsflowproject.domain


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflowproject.data.NewsRepository
import com.example.newsflowproject.domain.utils.NewsStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {


    private val mutableStateFlow: MutableStateFlow<List<NewsDomainModel>> =
        MutableStateFlow(ArrayList())
    var stateFlow: StateFlow<List<NewsDomainModel>> = mutableStateFlow.asStateFlow()

    init {
        startNews()
    }

    fun startNews() {
        viewModelScope.launch {
            newsRepository.requestNews()
                .onStart {
//                    mutableStateFlow.value = NewsStates.error("",null)
                }
                .map {
//                    NewsStates.success(it)
                    it
                }
                .catch { e ->
//                    mutableLiveData.postValue(Resource.error(e.toString(), null))
                    Log.e("MainActivity", "startNews: $e ")
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    mutableStateFlow.value = it
                }

        }
    }

}