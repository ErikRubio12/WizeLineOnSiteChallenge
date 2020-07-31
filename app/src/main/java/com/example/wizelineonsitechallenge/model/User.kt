package com.example.wizelineonsitechallenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class User (
    @SerializedName("id") @Expose val id : Double = 0.0,
    @SerializedName("id_str") @Expose val id_str : String = "",
    @SerializedName("name") @Expose val name : String = "",
    @SerializedName("screen_name") @Expose val screen_name : String = "",
    @SerializedName("location") @Expose val location : String = "",
    @SerializedName("description") @Expose val description : String = "",
    @SerializedName("url") @Expose val url : String = "",
    @SerializedName("entities") @Expose val entities : Entities = Entities(),
    @SerializedName("protected") @Expose val protected : Boolean = false,
    @SerializedName("followers_count") @Expose val followers_count : Int = 0,
    @SerializedName("friends_count") @Expose val friends_count : Int = 0,
    @SerializedName("listed_count") @Expose val listed_count : Int = 0,
    @SerializedName("created_at") @Expose val created_at : String = "",
    @SerializedName("favourites_count") @Expose val favourites_count : Int = 0,
    @SerializedName("utc_offset") @Expose val utc_offset : String = "",
    @SerializedName("time_zone") @Expose val time_zone : String = "",
    @SerializedName("geo_enabled") @Expose val geo_enabled : Boolean = false,
    @SerializedName("verified") @Expose val verified : Boolean = false,
    @SerializedName("statuses_count") @Expose val statuses_count : Int = 0,
    @SerializedName("lang") @Expose val lang : String = "",
    @SerializedName("status") @Expose val status : Status = Status(),
    @SerializedName("contributors_enabled") @Expose val contributors_enabled : Boolean = false,
    @SerializedName("is_translator") @Expose val is_translator : Boolean = false,
    @SerializedName("is_translation_enabled") @Expose val is_translation_enabled : Boolean = false,
    @SerializedName("profile_background_color") @Expose val profile_background_color : String = "",
    @SerializedName("profile_background_image_url") @Expose val profile_background_image_url : String = "",
    @SerializedName("profile_background_image_url_https") @Expose val profile_background_image_url_https : String = "",
    @SerializedName("profile_background_tile") @Expose val profile_background_tile : Boolean = false,
    @SerializedName("profile_image_url") @Expose val profile_image_url : String = "",
    @SerializedName("profile_image_url_https") @Expose val profile_image_url_https : String = "",
    @SerializedName("profile_banner_url") @Expose val profile_banner_url : String = "",
    @SerializedName("profile_link_color") @Expose val profile_link_color : String = "",
    @SerializedName("profile_sidebar_border_color") @Expose val profile_sidebar_border_color : String = "",
    @SerializedName("profile_sidebar_fill_color") @Expose val profile_sidebar_fill_color : String = "",
    @SerializedName("profile_text_color") @Expose val profile_text_color : Int = 0,
    @SerializedName("profile_use_background_image") @Expose val profile_use_background_image : Boolean = false,
    @SerializedName("has_extended_profile") @Expose val has_extended_profile : Boolean = false,
    @SerializedName("default_profile") @Expose val default_profile : Boolean = false,
    @SerializedName("default_profile_image") @Expose val default_profile_image : Boolean = false,
    @SerializedName("following") @Expose val following : Boolean = false,
    @SerializedName("follow_request_sent") @Expose val follow_request_sent : Boolean = false,
    @SerializedName("notifications") @Expose val notifications : Boolean = false,
    @SerializedName("translator_type") @Expose val translator_type : String = "",
    @SerializedName("suspended") @Expose val suspended : Boolean = false,
    @SerializedName("needs_phone_verification") @Expose val needs_phone_verification : Boolean = false
): Serializable