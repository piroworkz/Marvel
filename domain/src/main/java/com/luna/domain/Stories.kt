package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Items

data class Stories(
    val characters: Items,
    val comics: Items,
    val creators: Items,
    val description: String,
    val events: Items,
    val id: String,
    val modified: String,
    val originalissue: Item,
    val resourceURI: String,
    val series: Items,
    val thumbnail: Image,
    val title: String,
    val type: String
)