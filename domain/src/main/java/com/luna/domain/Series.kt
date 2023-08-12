package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Items
import com.luna.domain.common.Url

data class Series(
    val characters: Items,
    val comics: Items,
    val creators: Items,
    val description: String,
    val endYear: String,
    val events: Items,
    val id: String,
    val modified: String,
    val next: Item,
    val previous: Item,
    val rating: String,
    val resourceURI: String,
    val startYear: String,
    val stories: Items,
    val thumbnail: Image,
    val title: String,
    val urls: List<Url>,
)