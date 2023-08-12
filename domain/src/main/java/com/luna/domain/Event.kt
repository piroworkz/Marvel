package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Object
import com.luna.domain.common.Url

data class Event(
    val characters: Object,
    val comics: Object,
    val creators: Object,
    val description: String,
    val end: String,
    val id: String,
    val modified: String,
    val next: Item,
    val previous: Item,
    val resourceURI: String,
    val series: Object,
    val start: String,
    val stories: Object,
    val thumbnail: Image,
    val title: String,
    val urls: List<Url>,
)