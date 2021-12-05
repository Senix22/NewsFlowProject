package com.example.newsflowproject.domain


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

    val mutableLiveData = MutableLiveData<Resource<List<NewsDomainModel>>>()
//    lateinit var newsDomainModel: NewsDomainModel
//    val mutableLiveDate = MutableStateFlow<NewsDomainModel>(newsDomainModel)
//    val liveData  : StateFlow<NewsDomainModel> = mutableLiveDate
//    val result: Flow<NewsDomainModel> = flow {
//        val data = newsRepository.requestNews()
//        emit(data)
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000L),
//        initialValue = State.Content
//    )

    init {
        startNews()
    }
    private fun startNews() {
        viewModelScope.launch {
//            mutableLiveData.postValue(Resource.loading(null))
            newsRepository.requestNews()
                .flowOn(Dispatchers.IO)
                .onStart {
                    mutableLiveData.postValue(Resource.loading(null))
                }
                .catch { e ->
                    mutableLiveData.postValue(Resource.error(e.toString(), null))
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


//    fun handleMusicEventsAction(musicEvent: OpenUrlScreenAction) {
//        if (musicEvent.url.isEmpty()) return
//        appNavigator.openMusicItemScreen(musicEvent.url)
//    }

}