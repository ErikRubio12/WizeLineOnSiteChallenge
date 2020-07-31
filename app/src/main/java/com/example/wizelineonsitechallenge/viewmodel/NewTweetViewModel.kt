package com.example.wizelineonsitechallenge.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.wizelineonsitechallenge.model.Timeline
import com.example.wizelineonsitechallenge.repository.TimelineRepository
import com.example.wizelineonsitechallenge.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

class NewTweetViewModel
@ViewModelInject
constructor(
    private val timelineRepository: TimelineRepository,
    @Assisted private val stateHandle: SavedStateHandle
): ViewModel(){
    private var _tweetDataState: MutableLiveData<DataState<Timeline>> = MutableLiveData()
    val tweetDataState: LiveData<DataState<Timeline>>
        get() = _tweetDataState

    /*@ExperimentalCoroutinesApi
    fun newTweetEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetUserEvent{
                }
            }
        }
    }*/
}