package com.luna.marvel.domain

import com.luna.marvel.domain.common.Image
import com.luna.marvel.domain.common.Item
import com.luna.marvel.domain.common.Items
import com.luna.marvel.domain.common.Url

data class Event(
    val characters: Items,
    val comics: Items,
    val creators: Items,
    val description: String,
    val end: String,
    val id: String,
    val modified: String,
    val next: Item,
    val previous: Item,
    val resourceURI: String,
    val series: Items,
    val start: String,
    val stories: Items,
    val thumbnail: Image,
    val title: String,
    val urls: List<Url>,
)