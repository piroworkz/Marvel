package com.luna.marvel.app.data.remote.model.common

data class RemoteItem(
    val name: String,
    val resourceURI: String,
    val role: String?,
    val type: String?
)