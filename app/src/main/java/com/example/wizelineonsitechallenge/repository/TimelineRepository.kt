package com.example.wizelineonsitechallenge.repository

import com.example.wizelineonsitechallenge.model.Timeline
import com.example.wizelineonsitechallenge.retrofit.RetrofitApi
import com.example.wizelineonsitechallenge.util.DataState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

class TimelineRepository
constructor(
    private val retrofitApi: RetrofitApi
){
    suspend fun getTimeLine(): Flow<DataState<List<Timeline>>> =
        flow {
            emit(DataState.Loading)
            try {
                val networkTimeline = retrofitApi.getTimeline()
                emit(DataState.Success(networkTimeline))
            }catch (e: Exception){
                emit(DataState.Error(e))
            }
        }

    suspend fun newTweet(){

    }


}