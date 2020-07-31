package com.example.wizelineonsitechallenge.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Description (
    @SerializedName("urls") val urls : List<String>
): Serializable