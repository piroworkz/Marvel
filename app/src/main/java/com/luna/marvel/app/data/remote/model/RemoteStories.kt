package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteItems

data class RemoteStories(
    val characters: RemoteItems,
    val comics: RemoteItems,
    val creators: RemoteItems,
    val description: String,
    val events: RemoteItems,
    val id: Int,
    val modified: String,
    val originalissue: RemoteItem,
    val resourceURI: String,
    val series: RemoteItems,
    val thumbnail: RemoteImage,
    val title: String,
    val type: String
)