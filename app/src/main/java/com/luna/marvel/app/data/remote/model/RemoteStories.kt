package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteObject

data class RemoteStories(
    val characters: RemoteObject,
    val comics: RemoteObject,
    val creators: RemoteObject,
    val description: String,
    val events: RemoteObject,
    val id: Int,
    val modified: String,
    val originalissue: RemoteItem?,
    val resourceURI: String,
    val series: RemoteObject,
    val thumbnail: RemoteImage?,
    val title: String,
    val type: String
)