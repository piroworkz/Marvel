package com.luna.marvel.domain.common

data class Item(
    val name: String,
    val resourceURI: String,
    val role: String?,
    val type: String?
)