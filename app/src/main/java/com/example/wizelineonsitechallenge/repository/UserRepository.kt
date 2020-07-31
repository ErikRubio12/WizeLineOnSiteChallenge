package com.example.wizelineonsitechallenge.repository

import com.example.wizelineonsitechallenge.model.User
import com.example.wizelineonsitechallenge.retrofit.RetrofitApi
import com.example.wizelineonsitechallenge.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class UserRepository
constructor(
    private val retrofitApi: RetrofitApi
){
    suspend fun getUser(): Flow<DataState<User>> =
        flow {
            emit(DataState.Loading)
            try {
                val networkUser = retrofitApi.getUser()
                emit(DataState.Success(networkUser))
            }catch (e: Exception){
                emit(DataState.Error(e))
            }
        }
}