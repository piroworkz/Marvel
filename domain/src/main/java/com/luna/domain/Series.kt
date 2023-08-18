package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Object
import com.luna.domain.common.Url

data class Series(
    val characters: Object,
    val comics: Object,
    val creators: Object,
    val description: String,
    val endYear: String,
    val events: Object,
    val id: Int,
    val modified: String,
    val next: Item,
    val previous: Item,
    val rating: String,
    val resourceURI: String,
    val startYear: String,
    val stories: Object,
    val thumbnail: Image,
    val title: String,
    val urls: List<Url>,
)