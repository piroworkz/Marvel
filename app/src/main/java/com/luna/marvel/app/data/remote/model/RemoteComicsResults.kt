package com.luna.marvel.app.data.remote.model

import com.luna.marvel.app.data.remote.model.common.RemoteDate
import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteItems
import com.luna.marvel.app.data.remote.model.common.RemotePrice
import com.luna.marvel.app.data.remote.model.common.RemoteTextObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

data class RemoteComicsResults(
    val characters: RemoteItems,
    val collectedIssues: List<RemoteItem>,
    val collections: List<RemoteItem>,
    val creators: RemoteItems,
    val dates: List<RemoteDate>,
    val description: String,
    val diamondCode: String,
    val digitalId: String,
    val ean: String,
    val events: RemoteItems,
    val format: String,
    val id: String,
    val images: List<RemoteImage>,
    val isbn: String,
    val issn: String,
    val issueNumber: String,
    val modified: String,
    val pageCount: String,
    val prices: List<RemotePrice>,
    val resourceURI: String,
    val series: RemoteItem,
    val stories: RemoteItems,
    val textObjects: List<RemoteTextObject>,
    val thumbnail: RemoteImage,
    val title: String,
    val upc: String,
    val urls: List<RemoteUrl>,
    val variantDescription: String,
    val variants: List<RemoteItem>,
)