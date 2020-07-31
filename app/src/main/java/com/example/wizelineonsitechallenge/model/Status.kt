package com.example.wizelineonsitechallenge.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Status (
    @SerializedName("created_at") val created_at : String = "",
    @SerializedName("id") val id : Int = 0,
    @SerializedName("id_str") val id_str : Int = 0,
    @SerializedName("text") val text : String = "",
    @SerializedName("truncated") val truncated : Boolean = false,
    @SerializedName("entities") val entities : Entities = Entities(),
    @SerializedName("source") val source : String = "",
    @SerializedName("in_reply_to_status_id") val in_reply_to_status_id : String = "",
    @SerializedName("in_reply_to_status_id_str") val in_reply_to_status_id_str : String = "",
    @SerializedName("in_reply_to_user_id") val in_reply_to_user_id : String = "",
    @SerializedName("in_reply_to_user_id_str") val in_reply_to_user_id_str : String = "",
    @SerializedName("in_reply_to_screen_name") val in_reply_to_screen_name : String = "",
    @SerializedName("geo") val geo : String = "",
    @SerializedName("coordinates") val coordinates : String = "",
    @SerializedName("place") val place : String = "",
    @SerializedName("contributors") val contributors : String = "",
    @SerializedName("is_quote_status") val is_quote_status : Boolean = false,
    @SerializedName("retweet_count") val retweet_count : Int = 0,
    @SerializedName("favorite_count") val favorite_count : Int = 0,
    @SerializedName("favorited") val favorited : Boolean = false,
    @SerializedName("retweeted") val retweeted : Boolean = false,
    @SerializedName("lang") val lang : String = ""
): Serializable