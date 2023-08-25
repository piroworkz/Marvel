package com.luna.marvel.app.data.remote.datasources

import com.luna.data.sources.ComicsDataSource
import com.luna.domain.MarvelItem
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeStories
import com.luna.testshared.tryCatch

class FakeRemoteComicsDataSource : ComicsDataSource {
    var comics: List<MarvelItem> = fakeMarvelItems

    override suspend fun getComics() =
        tryCatch { comics }

    override suspend fun getComicById(id: Int) = tryCatch {
        if (id != 0) fakeComics else emptyList()
    }

    override suspend fun getComicCharactersById(id: Int) =
        tryCatch {
            if (id != 0) fakeCharacters else emptyList()
        }

    override suspend fun getComicCreatorsById(id: Int) =
        tryCatch {
            if (id != 0) fakeCreators else emptyList()
        }

    override suspend fun getComicEventsById(id: Int) = tryCatch {
        if (id != 0) fakeEvents else emptyList()
    }

    override suspend fun getComicStoriesById(id: Int) = tryCatch {
        if (id != 0) fakeStories else emptyList()
    }
}