package com.luna.marvel.domain

import com.luna.marvel.domain.common.Image
import com.luna.marvel.domain.common.Items
import com.luna.marvel.domain.common.Url

data class Creators(
    val comics: Items,
    val events: Items,
    val firstName: String,
    val fullName: String,
    val id: String,
    val lastName: String,
    val middleName: String,
    val modified: String,
    val resourceURI: String,
    val series: Items,
    val stories: Items,
    val suffix: String,
    val thumbnail: Image,
    val urls: List<Url>
)