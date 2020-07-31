package com.example.wizelineonsitechallenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Timeline (
    @SerializedName("created_at") @Expose val created_at : String = "",
    @SerializedName("id") @Expose val id : Double = 0.0,
    @SerializedName("id_str") @Expose val id_str : String = "",
    @SerializedName("text") @Expose val text : String = "",
    @SerializedName("truncated") @Expose val truncated : Boolean = false,
    @SerializedName("entities") @Expose val entities : Entities = Entities(),
    @SerializedName("source") @Expose val source : String = "",
    @SerializedName("in_reply_to_status_id") @Expose val in_reply_to_status_id : String = "",
    @SerializedName("in_reply_to_status_id_str") @Expose val in_reply_to_status_id_str : String = "",
    @SerializedName("in_reply_to_user_id") @Expose val in_reply_to_user_id : String = "",
    @SerializedName("in_reply_to_user_id_str") @Expose val in_reply_to_user_id_str : String = "",
    @SerializedName("in_reply_to_screen_name") @Expose val in_reply_to_screen_name : String = "",
    @SerializedName("user") @Expose val user : User = User(),
    @SerializedName("geo") @Expose val geo : String = "",
    @SerializedName("coordinates") @Expose val coordinates : String = "",
    @SerializedName("place") @Expose val place : String = "",
    @SerializedName("contributors") @Expose val contributors : String = "",
    @SerializedName("is_quote_status") @Expose val is_quote_status : Boolean = false,
    @SerializedName("retweet_count") @Expose val retweet_count : Int = 0,
    @SerializedName("favorite_count") @Expose val favorite_count : Int = 0,
    @SerializedName("favorited") @Expose val favorited : Boolean = false,
    @SerializedName("retweeted") @Expose val retweeted : Boolean = false,
    @SerializedName("lang") @Expose val lang : String = ""
): Serializable