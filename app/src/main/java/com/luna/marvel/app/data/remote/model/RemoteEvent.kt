package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteItems
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteEvent(
    val characters: RemoteItems,
    val comics: RemoteItems,
    val creators: RemoteItems,
    val description: String,
    val end: String,
    val id: Int,
    val modified: String,
    val next: RemoteItem,
    val previous: RemoteItem,
    val resourceURI: String,
    val series: RemoteItems,
    val start: String,
    val stories: RemoteItems,
    val thumbnail: RemoteImage,
    val title: String,
    val urls: List<RemoteUrl>
)