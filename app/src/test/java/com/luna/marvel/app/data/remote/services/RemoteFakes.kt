package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import com.luna.marvel.app.data.remote.model.common.RemoteData
import com.luna.marvel.app.data.remote.model.common.RemoteDate
import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteObject
import com.luna.marvel.app.data.remote.model.common.RemotePrice
import com.luna.marvel.app.data.remote.model.common.RemoteTextObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl

inline fun <reified T> buildResponseWith(response: List<T>): MarvelNetworkResponse<T> {
    return MarvelNetworkResponse(
        attributionHTML = "sapien",
        attributionText = "tincidunt",
        code = "possit",
        copyright = "class",
        data = RemoteData(
            count = "mauris",
            limit = "sumo",
            offset = "petentium",
            results = response,
            total = "labores"
        ),
        etag = "doming",
        status = "debet"
    )
}

val fakeRemoteTextObject = RemoteTextObject(
    language = "en-us",
    text = "text",
    type = "type"
)

val fakeRemoteTextObjects = (0..2).map { fakeRemoteTextObject }

val fakeRemoteDate = RemoteDate(
    date = "2019-12-31T00:00:00-0500",
    type = "onsaleDate"
)

val fakeRemoteDates = (0..2).map { fakeRemoteDate }

val fakeRemotePrice = RemotePrice(
    price = "3.99",
    type = "printPrice"
)

val fakeRemotePrices = (0..2).map { fakeRemotePrice }

val fakeRemoteImage = RemoteImage(
    extension = "jpg",
    path = "nominavi"
)

val fakeRemoteImages = (0..2).map {
    fakeRemoteImage
}

val fakeRemoteUrls = (0..2).map {
    RemoteUrl(
        type = "null",
        url = "nec"
    )
}

val fakeRemoteItem = RemoteItem(
    name = "Arline Francis",
    resourceURI = "atqui",
    role = "null",
    type = "null"
)

val fakeRemoteItems = (0..2).map { fakeRemoteItem }

val fakeRemoteObject = RemoteObject(
    available = "graecis",
    collectionURI = "erroribus",
    items = fakeRemoteItems,
    returned = "orci"
)


val fakeRemoteCharacters = (0..2).map {
    RemoteCharacter(
        comics = fakeRemoteObject,
        description = "quas",
        events = fakeRemoteObject,
        id = 8719,
        modified = "litora",
        name = "Cora Blanchard",
        resourceURI = "natum",
        series = fakeRemoteObject,
        stories = fakeRemoteObject,
        thumbnail = fakeRemoteImage,
        urls = fakeRemoteUrls
    )
}

val fakeRemoteEvents = (0..2).map {
    RemoteEvent(
        characters = fakeRemoteObject,
        comics = fakeRemoteObject,
        creators = fakeRemoteObject,
        description = "mutat",
        end = "utamur",
        id = 8719,
        modified = "quaestio",
        next = fakeRemoteItem,
        previous = fakeRemoteItem,
        resourceURI = "utroque",
        series = fakeRemoteObject,
        start = "falli",
        stories = fakeRemoteObject,
        thumbnail = fakeRemoteImage,
        title = "Cora Blanchard",
        urls = fakeRemoteUrls
    )
}

val fakeRemoteSeries = (0..2).map {
    RemoteSeries(
        characters = fakeRemoteObject,
        comics = fakeRemoteObject,
        creators = fakeRemoteObject,
        description = "mutat",
        endYear = "utamur",
        events = fakeRemoteObject,
        id = 8719,
        modified = "quaestio",
        next = fakeRemoteItem,
        previous = fakeRemoteItem,
        rating = "utroque",
        resourceURI = "falli",
        startYear = "id",
        stories = fakeRemoteObject,
        thumbnail = fakeRemoteImage,
        title = "Cora Blanchard",
        urls = fakeRemoteUrls
    )
}

val fakeRemoteStories = (0..2).map {
    RemoteStories(
        characters = fakeRemoteObject,
        comics = fakeRemoteObject,
        creators = fakeRemoteObject,
        description = "mutat",
        events = fakeRemoteObject,
        id = 8719,
        modified = "quaestio",
        originalissue = fakeRemoteItem,
        resourceURI = "utroque",
        series = fakeRemoteObject,
        thumbnail = fakeRemoteImage,
        title = "Cora Blanchard",
        type = "id"
    )
}


val fakeRemoteComics = (0..2).map {
    RemoteComic(
        characters = fakeRemoteObject,
        collectedIssues = fakeRemoteItems,
        collections = fakeRemoteItems,
        creators = fakeRemoteObject,
        dates = fakeRemoteDates,
        description = "feugait",
        diamondCode = "tota",
        digitalId = "ponderum",
        ean = "accumsan",
        events = fakeRemoteObject,
        format = "scripserit",
        id = 8719,
        images = fakeRemoteImages,
        isbn = "per",
        issn = "perpetua",
        issueNumber = "eruditi",
        modified = "atomorum",
        pageCount = "sodales",
        prices = fakeRemotePrices,
        resourceURI = "auctor",
        series = fakeRemoteItem,
        stories = fakeRemoteObject,
        textObjects = fakeRemoteTextObjects,
        thumbnail = fakeRemoteImage,
        title = "Cora Blanchard",
        upc = "scelerisque",
        urls = fakeRemoteUrls,
        variantDescription = "eleifend",
        variants = fakeRemoteItems
    )
}

val fakeRemoteCreators = (0..2).map {
    RemoteCreators(
        comics = fakeRemoteObject,
        events = fakeRemoteObject,
        firstName = "Wilbur Graham",
        fullName = "Cora Blanchard",
        id = 8719,
        lastName = "Sean Maxwell",
        middleName = "Brent Rasmussen",
        modified = "consequat",
        resourceURI = "placerat",
        series = fakeRemoteObject,
        stories = fakeRemoteObject,
        suffix = "venenatis",
        thumbnail = fakeRemoteImage,
        urls = fakeRemoteUrls
    )
}