package com.luna.marvel.domain

import com.luna.marvel.domain.common.Image
import com.luna.marvel.domain.common.Items
import com.luna.marvel.domain.common.Url

data class Character(
    val comics: Items,
    val description: String,
    val events: Items,
    val id: String,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Items,
    val stories: Items,
    val thumbnail: Image,
    val urls: List<Url>
)