package com.luna.marvel.app.data.remote.model.common

data class RemoteData<T>(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<T>,
    val total: String
)