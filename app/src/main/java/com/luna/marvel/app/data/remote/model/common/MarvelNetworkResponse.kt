package com.luna.marvel.app.data.remote.model.common

data class MarvelNetworkResponse<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val data: RemoteData<T>,
    val etag: String,
    val status: String
)