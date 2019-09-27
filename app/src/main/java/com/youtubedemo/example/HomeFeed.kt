package com.youtubedemo.example


import com.google.gson.annotations.SerializedName

data class HomeFeed(
    @SerializedName("videos")
    val videos: List<Video>
)