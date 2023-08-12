package com.luna.marvel.app.data.remote.model.common

data class RemoteItems(
    val available: String,
    val collectionURI: String,
    val items: List<RemoteItem>,
    val returned: String
)