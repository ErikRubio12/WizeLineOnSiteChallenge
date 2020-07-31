package com.example.wizelineonsitechallenge.retrofit

import com.example.wizelineonsitechallenge.model.Timeline
import com.example.wizelineonsitechallenge.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {

    @GET("api/user")
    suspend fun getUser(): User

    @GET("api/statuses/user_timeline")
    suspend fun getTimeline(): List<Timeline>

    @POST("api/statuses/update")
    suspend fun newTweet(@Body tweet: Timeline): Response<Timeline>

}