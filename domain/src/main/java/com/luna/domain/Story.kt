package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Object

data class Story(
    val characters: Object,
    val comics: Object,
    val creators: Object,
    val description: String,
    val events: Object,
    val id: Int,
    val modified: String,
    val originalissue: Item?,
    val resourceURI: String,
    val series: Object,
    val thumbnail: Image,
    val title: String,
    val type: String
)