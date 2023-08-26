package com.luna.domain

import com.luna.domain.common.Image
import com.luna.domain.common.Object
import com.luna.domain.common.Url

data class Creator(
    val comics: Object,
    val events: Object,
    val firstName: String,
    val fullName: String,
    val id: Int,
    val lastName: String,
    val middleName: String,
    val modified: String,
    val resourceURI: String,
    val series: Object,
    val stories: Object,
    val suffix: String,
    val thumbnail: Image,
    val urls: List<Url>
)