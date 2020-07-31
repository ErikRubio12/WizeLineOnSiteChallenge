package com.example.wizelineonsitechallenge.di

import com.example.wizelineonsitechallenge.repository.TimelineRepository
import com.example.wizelineonsitechallenge.repository.UserRepository
import com.example.wizelineonsitechallenge.retrofit.RetrofitApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesUserRepository(
        retrofit: RetrofitApi
    ): UserRepository{
        return UserRepository(
            retrofitApi = retrofit
        )
    }

    @Singleton
    @Provides
    fun providesTimelinerRepository(
        retrofit: RetrofitApi
    ): TimelineRepository{
        return TimelineRepository(
            retrofitApi = retrofit
        )
    }

}