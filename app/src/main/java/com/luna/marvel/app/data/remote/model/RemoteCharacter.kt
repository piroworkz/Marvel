package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteCharacter(
    val comics: RemoteObject,
    val description: String,
    val events: RemoteObject,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: RemoteObject,
    val stories: RemoteObject,
    val thumbnail: RemoteImage,
    val urls: List<RemoteUrl>
)