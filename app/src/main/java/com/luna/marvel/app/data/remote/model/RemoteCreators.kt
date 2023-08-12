package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItems
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteCreators(
    val comics: RemoteItems,
    val events: RemoteItems,
    val firstName: String,
    val fullName: String,
    val id: String,
    val lastName: String,
    val middleName: String,
    val modified: String,
    val resourceURI: String,
    val series: RemoteItems,
    val stories: RemoteItems,
    val suffix: String,
    val thumbnail: RemoteImage,
    val urls: List<RemoteUrl>
)