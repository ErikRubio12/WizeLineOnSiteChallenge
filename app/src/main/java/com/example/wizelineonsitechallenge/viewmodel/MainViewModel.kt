package com.example.wizelineonsitechallenge.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.wizelineonsitechallenge.model.Timeline
import com.example.wizelineonsitechallenge.model.User
import com.example.wizelineonsitechallenge.repository.TimelineRepository
import com.example.wizelineonsitechallenge.repository.UserRepository
import com.example.wizelineonsitechallenge.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModelTwo
@ViewModelInject
constructor(
    private val userRepository: UserRepository,
    private val timelineRepository: TimelineRepository,
    @Assisted private val stateHandle: SavedStateHandle
): ViewModel(){
    private var _userDataState: MutableLiveData<DataState<User>> = MutableLiveData()
    val userDataState: LiveData<DataState<User>>
        get() = _userDataState

    private var _timelineDataState: MutableLiveData<DataState<List<Timeline>>> = MutableLiveData()
    val timelineDataState: LiveData<DataState<List<Timeline>>>
        get() = _timelineDataState

    @ExperimentalCoroutinesApi
    fun setUserStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetUserEvent ->{
                    userRepository.getUser()
                        .onEach {
                            _userDataState.value = it
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    fun setTimelineStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetTimelineEvent ->{
                    timelineRepository.getTimeLine()
                        .onEach {
                            _timelineDataState.value = it
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

}

sealed class MainStateEvent{
    object GetUserEvent: MainStateEvent()
    object GetTimelineEvent: MainStateEvent()
}
