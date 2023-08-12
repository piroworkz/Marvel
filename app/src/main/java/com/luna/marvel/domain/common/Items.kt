package com.luna.marvel.domain.common

data class Items(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)