package com.luna.domain.common

data class Object(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)