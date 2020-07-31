package com.example.wizelineonsitechallenge.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Entities (
    @SerializedName("hashtags") val hashtags : List<String> = emptyList(),
    @SerializedName("symbols") val symbols : List<String> = emptyList(),
    @SerializedName("user_mentions") val user_mentions : List<String> = emptyList(),
    @SerializedName("description") val description : List<Description> = emptyList()
): Serializable