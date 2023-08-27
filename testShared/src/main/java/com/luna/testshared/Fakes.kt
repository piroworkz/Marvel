package com.luna.testshared

import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story
import com.luna.domain.common.Date
import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.domain.common.Object
import com.luna.domain.common.Price
import com.luna.domain.common.TextObject
import com.luna.domain.common.Url


val fakeTextObject = TextObject(
    language = "en-us",
    text = "text",
    type = "type"
)

val fakeTextObjects = (0..2).map { fakeTextObject }

val fakeDate = Date(
    date = "2019-12-31T00:00:00-0500",
    type = "onsaleDate"
)

val fakeDates = (0..2).map { fakeDate }

val fakePrice = Price(
    price = "3.99",
    type = "printPrice"
)

val fakePrices = (0..2).map { fakePrice }

val fakeImage = Image(
    extension = "jpg",
    path = "nominavi.jpg"
)

val fakeImages = (0..2).map {
    fakeImage
}

val fakeUrls = (0..2).map {
    Url(
        type = "null",
        url = "nec"
    )
}

val fakeItem = Item(
    name = "Arline Francis",
    resourceURI = "atqui",
    role = "null",
    type = "null"
)

val fakeItems = (0..2).map { fakeItem }

val fakeObject = Object(
    available = "graecis",
    collectionURI = "erroribus",
    items = fakeItems,
    returned = "orci"
)

val fakeMarvelItems = (0..2).map {
    MarvelItem(
        id = 8719,
        name = "Cora Blanchard",
        thumbnail = fakeImage
    )
}

val fakeError = AppError.NetworkError
val fakeUnknownError = AppError.UnknownError
val fakeNotAvailableError = AppError.NotAvailable

val fakeCharacters = (0..2).map {
    Character(
        comics = fakeObject,
        description = "quas",
        events = fakeObject,
        id = 8719,
        modified = "litora",
        name = "Cora Blanchard",
        resourceURI = "natum",
        series = fakeObject,
        stories = fakeObject,
        thumbnail = fakeImage,
        urls = fakeUrls
    )
}

val fakeEvents = (0..2).map {
    Event(
        characters = fakeObject,
        comics = fakeObject,
        creators = fakeObject,
        description = "mutat",
        end = "utamur",
        id = 8719,
        modified = "quaestio",
        next = fakeItem,
        previous = fakeItem,
        resourceURI = "utroque",
        series = fakeObject,
        start = "falli",
        stories = fakeObject,
        thumbnail = fakeImage,
        title = "Cora Blanchard",
        urls = fakeUrls
    )
}

val fakeSeries = (0..2).map {
    Series(
        characters = fakeObject,
        comics = fakeObject,
        creators = fakeObject,
        description = "mutat",
        endYear = "utamur",
        events = fakeObject,
        id = 8719,
        modified = "quaestio",
        next = fakeItem,
        previous = fakeItem,
        rating = "utroque",
        resourceURI = "falli",
        startYear = "id",
        stories = fakeObject,
        thumbnail = fakeImage,
        title = "Cora Blanchard",
        urls = fakeUrls
    )
}

val fakeStories = (0..2).map {
    Story(
        characters = fakeObject,
        comics = fakeObject,
        creators = fakeObject,
        description = "mutat",
        events = fakeObject,
        id = 8719,
        modified = "quaestio",
        originalissue = fakeItem,
        resourceURI = "utroque",
        series = fakeObject,
        thumbnail = fakeImage,
        title = "Cora Blanchard",
        type = "id"
    )
}


val fakeComics = (0..2).map {
    Comic(
        characters = fakeObject,
        collectedIssues = fakeItems,
        collections = fakeItems,
        creators = fakeObject,
        dates = fakeDates,
        description = "feugait",
        diamondCode = "tota",
        digitalId = "ponderum",
        ean = "accumsan",
        events = fakeObject,
        format = "scripserit",
        id = 8719,
        images = fakeImages,
        isbn = "per",
        issn = "perpetua",
        issueNumber = "eruditi",
        modified = "atomorum",
        pageCount = "sodales",
        prices = fakePrices,
        resourceURI = "auctor",
        series = fakeItem,
        stories = fakeObject,
        textObjects = fakeTextObjects,
        thumbnail = fakeImage,
        title = "Cora Blanchard",
        upc = "scelerisque",
        urls = fakeUrls,
        variantDescription = "eleifend",
        variants = fakeItems
    )
}

val fakeCreators = (0..2).map {
    Creator(
        comics = fakeObject,
        events = fakeObject,
        firstName = "Wilbur Graham",
        fullName = "Cora Blanchard",
        id = 8719,
        lastName = "Sean Maxwell",
        middleName = "Brent Rasmussen",
        modified = "consequat",
        resourceURI = "placerat",
        series = fakeObject,
        stories = fakeObject,
        suffix = "venenatis",
        thumbnail = fakeImage,
        urls = fakeUrls
    )
}