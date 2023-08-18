package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItems
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteCharacter(
    val comics: RemoteItems,
    val description: String,
    val events: RemoteItems,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: RemoteItems,
    val stories: RemoteItems,
    val thumbnail: RemoteImage,
    val urls: List<RemoteUrl>
)