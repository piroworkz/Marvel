package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteCreators(
    val comics: RemoteObject,
    val events: RemoteObject,
    val firstName: String,
    val fullName: String,
    val id: Int,
    val lastName: String,
    val middleName: String,
    val modified: String,
    val resourceURI: String,
    val series: RemoteObject,
    val stories: RemoteObject,
    val suffix: String,
    val thumbnail: RemoteImage,
    val urls: List<RemoteUrl>
)