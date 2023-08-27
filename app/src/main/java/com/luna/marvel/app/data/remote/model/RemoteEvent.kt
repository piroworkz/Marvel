package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteEvent(
    val characters: RemoteObject,
    val comics: RemoteObject,
    val creators: RemoteObject,
    val description: String,
    val end: String,
    val id: Int,
    val modified: String,
    val next: RemoteItem,
    val previous: RemoteItem,
    val resourceURI: String,
    val series: RemoteObject,
    val start: String,
    val stories: RemoteObject,
    val thumbnail: RemoteImage,
    val title: String,
    val urls: List<RemoteUrl>
)