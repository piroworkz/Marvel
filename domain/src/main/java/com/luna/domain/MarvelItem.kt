package com.luna.domain

import com.luna.domain.common.Image

data class MarvelItem(
    val id: Int,
    val name: String,
    val thumbnail: Image,
)

