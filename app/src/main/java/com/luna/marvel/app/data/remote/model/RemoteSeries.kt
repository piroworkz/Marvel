package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteSeries(
    val characters: RemoteObject,
    val comics: RemoteObject,
    val creators: RemoteObject,
    val description: String?,
    val endYear: String,
    val events: RemoteObject,
    val id: Int,
    val modified: String,
    val next: RemoteItem?,
    val previous: RemoteItem?,
    val rating: String,
    val resourceURI: String,
    val startYear: String,
    val stories: RemoteObject,
    val thumbnail: RemoteImage,
    val title: String,
    val urls: List<RemoteUrl>
)