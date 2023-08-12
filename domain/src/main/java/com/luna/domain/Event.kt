package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Items
import com.luna.domain.common.Url

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