package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.RemoteDate
import com.luna.marvel.app.data.remote.model.common.RemoteImage
import com.luna.marvel.app.data.remote.model.common.RemoteItem
import com.luna.marvel.app.data.remote.model.common.RemoteItems
import com.luna.marvel.app.data.remote.model.common.RemotePrice
import com.luna.marvel.app.data.remote.model.common.RemoteTextObject
import com.luna.marvel.app.data.remote.model.common.RemoteUrl
import com.luna.marvel.domain.Character
import com.luna.marvel.domain.Comic
import com.luna.marvel.domain.Creators
import com.luna.marvel.domain.Event
import com.luna.marvel.domain.Series
import com.luna.marvel.domain.Stories
import com.luna.marvel.domain.common.Date
import com.luna.marvel.domain.common.Image
import com.luna.marvel.domain.common.Item
import com.luna.marvel.domain.common.Items
import com.luna.marvel.domain.common.Price
import com.luna.marvel.domain.common.TextObject
import com.luna.marvel.domain.common.Url

fun RemoteCharacter.toDomain(): Character =
    Character(
        comics.toDomain(),
        description,
        events.toDomain(),
        id,
        modified,
        name,
        resourceURI,
        series.toDomain(),
        stories.toDomain(),
        thumbnail.toDomain(),
        urls.map { it.toDomain() }
    )

fun RemoteUrl.toDomain(): Url =
    Url(
        type = type,
        url = url
    )

fun RemoteImage.toDomain(): Image =
    Image(
        extension = extension,
        path = path
    )

fun RemoteItems.toDomain(): Items =
    Items(
        available = available,
        collectionURI = collectionURI,
        items = items.map(RemoteItem::toDomain),
        returned = returned
    )

fun RemoteItem.toDomain(): Item =
    Item(
        name = name,
        resourceURI = resourceURI,
        role = role,
        type = type
    )


fun RemoteComic.toDomain(): Comic {
    return Comic(
        characters = characters.toDomain(),
        collectedIssues = collectedIssues.map { it.toDomain() },
        collections = collections.map { it.toDomain() },
        creators = creators.toDomain(),
        dates = dates.map { it.toDomain() },
        description = description,
        diamondCode = diamondCode,
        digitalId = digitalId,
        ean = ean,
        events = events.toDomain(),
        format = format,
        id = id,
        images = images.map { it.toDomain() },
        isbn = isbn,
        issn = issn,
        issueNumber = issueNumber,
        modified = modified,
        pageCount = pageCount,
        prices = prices.map { it.toDomain() },
        resourceURI = resourceURI,
        series = series.toDomain(),
        stories = stories.toDomain(),
        textObjects = textObjects.map { it.toDomain() },
        thumbnail = thumbnail.toDomain(),
        title = title,
        upc = upc,
        urls = urls.map { it.toDomain() },
        variantDescription = variantDescription,
        variants = variants.map { it.toDomain() }
    )
}

fun RemoteTextObject.toDomain(): TextObject =
    TextObject(
        language = language,
        text = text,
        type = type
    )

fun RemotePrice.toDomain(): Price =
    Price(
        price = price,
        type = type
    )

fun RemoteDate.toDomain(): Date =
    Date(
        date = date,
        type = type
    )

fun RemoteCreators.toDomain(): Creators =
    Creators(
        comics = comics.toDomain(),
        events = events.toDomain(),
        firstName = firstName,
        fullName = fullName,
        id = id,
        lastName = lastName,
        middleName = middleName,
        modified = modified,
        resourceURI = resourceURI,
        series = series.toDomain(),
        stories = stories.toDomain(),
        suffix = suffix,
        thumbnail = thumbnail.toDomain(),
        urls = urls.map { it.toDomain() }
    )

fun RemoteEvent.toDomain(): Event {
    return Event(
        characters = characters.toDomain(),
        comics = comics.toDomain(),
        creators = creators.toDomain(),
        description = description,
        end = end,
        id = id,
        modified = modified,
        next = next.toDomain(),
        previous = previous.toDomain(),
        resourceURI = resourceURI,
        series = series.toDomain(),
        start = start,
        stories = stories.toDomain(),
        thumbnail = thumbnail.toDomain(),
        title = title,
        urls = urls.map { it.toDomain() }
    )
}

fun RemoteSeries.toDomain(): Series =
    Series(
        characters = characters.toDomain(),
        comics = comics.toDomain(),
        creators = creators.toDomain(),
        description = description,
        endYear = endYear,
        events = events.toDomain(),
        id = id,
        modified = modified,
        next = next.toDomain(),
        previous = previous.toDomain(),
        rating = rating,
        resourceURI = resourceURI,
        startYear = startYear,
        stories = stories.toDomain(),
        thumbnail = thumbnail.toDomain(),
        title = title,
        urls = urls.map { it.toDomain() }
    )

fun RemoteStories.toDomain(): Stories = Stories(
    characters = characters.toDomain(),
    comics = comics.toDomain(),
    creators = creators.toDomain(),
    description = description,
    events = events.toDomain(),
    id = id,
    modified = modified,
    originalissue = originalissue.toDomain(),
    resourceURI = resourceURI,
    series = series.toDomain(),
    thumbnail = thumbnail.toDomain(),
    title = title,
    type = type
)
