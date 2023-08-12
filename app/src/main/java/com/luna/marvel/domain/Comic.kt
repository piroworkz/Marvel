package com.luna.marvel.domain

import com.luna.marvel.domain.common.Date
import com.luna.marvel.domain.common.Image
import com.luna.marvel.domain.common.Item
import com.luna.marvel.domain.common.Items
import com.luna.marvel.domain.common.Price
import com.luna.marvel.domain.common.TextObject
import com.luna.marvel.domain.common.Url

data class Comic(
    val characters: Items,
    val collectedIssues: List<Item>,
    val collections: List<Item>,
    val creators: Items,
    val dates: List<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: String,
    val ean: String,
    val events: Items,
    val format: String,
    val id: String,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: String,
    val modified: String,
    val pageCount: String,
    val prices: List<Price>,
    val resourceURI: String,
    val series: Item,
    val stories: Items,
    val textObjects: List<TextObject>,
    val thumbnail: Image,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Item>
)