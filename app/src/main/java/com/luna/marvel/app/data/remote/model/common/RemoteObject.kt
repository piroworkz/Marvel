package com.luna.marvel.app.data.remote.model.common

data class RemoteObject(
    val available: String,
    val collectionURI: String,
    val items: List<RemoteItem>,
    val returned: String
)