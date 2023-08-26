package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Object
import com.luna.domain.common.Url

data class Character(
    val comics: Object,
    val description: String,
    val events: Object,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Object,
    val stories: Object,
    val thumbnail: Image,
    val urls: List<Url>
)