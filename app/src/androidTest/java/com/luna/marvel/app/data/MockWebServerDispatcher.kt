package com.luna.marvel.app.data

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

class MockWebServerDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return if (request.path != null) {
            when {
//                CHARACTERS
                request.path!!.contains("/1011334/comics?") -> {
                    MockResponse().setResponseFromFile("characters/characterComics.json")
                }

                request.path!!.contains("/1011334/events?") -> {
                    MockResponse().setResponseFromFile("characters/characterEvents.json")
                }

                request.path!!.contains("/1011334/series?") -> {
                    MockResponse().setResponseFromFile("characters/characterSeries.json")
                }

                request.path!!.contains("/1011334/stories?") -> {
                    MockResponse().setResponseFromFile("characters/characterStories.json")
                }

                request.path!!.contains("/characters/1011334?") -> {
                    MockResponse().setResponseFromFile("characters/characterById.json")
                }

                request.path!!.contains("/v1/public/characters?limit=100&apikey=12345678&ts=") -> {
                    println("<--  inside when ${request.path}")
                    MockResponse().setResponseFromFile("characters/characters.json")
                }
//              COMICS
                request.path!!.contains("/82970/characters?") -> {
                    MockResponse().setResponseFromFile("comics/comicCharacters.json")
                }

                request.path!!.contains("/82970/creators?") -> {
                    MockResponse().setResponseFromFile("comics/comicCreators.json")
                }

                request.path!!.contains("/82970/events?") -> {
                    MockResponse().setResponseFromFile("comics/comicEvents.json")
                }

                request.path!!.contains("/82970/stories?") -> {
                    MockResponse().setResponseFromFile("comics/comicStories.json")
                }

                request.path!!.contains("/comics/82970?") -> {
                    MockResponse().setResponseFromFile("comics/comicById.json")
                }

                request.path!!.contains("/v1/public/comics?limit=100&apikey=12345678&ts=") -> {
                    MockResponse().setResponseFromFile("comics/comics.json")
                }
//              CREATORS
                request.path!!.contains("/creators/9716/comics") -> {
                    println("<-- CREATORS COMICS")
                    MockResponse().setResponseFromFile("creators/creatorComics.json")
                }

                request.path!!.contains("/creators/9716/events") -> {
                    println("<-- CREATORS EVENTS")
                    MockResponse().setResponseFromFile("creators/creatorEvents.json")
                }

                request.path!!.contains("/creators/9716/series") -> {
                    println("<-- CREATORS SERIES")
                    MockResponse().setResponseFromFile("creators/creatorSeries.json")
                }

                request.path!!.contains("/creators/9716/stories") -> {
                    println("<-- CREATORS STORIES")
                    MockResponse().setResponseFromFile("creators/creatorStories.json")
                }

                request.path!!.contains("/creators/9716") -> {
                    println("<-- CREATORS DETAILS")
                    MockResponse().setResponseFromFile("creators/creatorsById.json")
                }

                request.path!!.contains("/v1/public/creators?limit=100&apikey=12345678&ts=") -> {
                    println("<-- CREATORS LIST")
                    MockResponse().setResponseFromFile("creators/creators.json")
                }
//                EVENTS

                request.path!!.contains("/events/116/characters") -> {
                    MockResponse().setResponseFromFile("events/eventCharacters.json")
                }

                request.path!!.contains("/events/116/comics") -> {
                    MockResponse().setResponseFromFile("events/eventComics.json")
                }

                request.path!!.contains("/events/116/creators") -> {
                    MockResponse().setResponseFromFile("events/eventCreators.json")
                }

                request.path!!.contains("/events/116/series") -> {
                    MockResponse().setResponseFromFile("events/eventSeries.json")
                }

                request.path!!.contains("/events/116/stories") -> {
                    MockResponse().setResponseFromFile("events/eventStories.json")
                }

                request.path!!.contains("/events/116") -> {
                    MockResponse().setResponseFromFile("events/eventById.json")
                }

                request.path!!.contains("/v1/public/events?limit=100&apikey=12345678&ts=") -> {
                    MockResponse().setResponseFromFile("events/events.json")
                }
//                SERIES
                request.path!!.contains("/series/18454/characters") -> {
                    MockResponse().setResponseFromFile("series/seriesCharacters.json")
                }

                request.path!!.contains("/series/18454/comics") -> {
                    MockResponse().setResponseFromFile("series/seriesComics.json")
                }

                request.path!!.contains("/series/18454/creators") -> {
                    MockResponse().setResponseFromFile("series/seriesCreators.json")
                }

                request.path!!.contains("/series/18454/events") -> {
                    MockResponse().setResponseFromFile("series/seriesEvents.json")
                }

                request.path!!.contains("/series/18454/stories") -> {
                    MockResponse().setResponseFromFile("series/seriesStories.json")
                }

                request.path!!.contains("/v1/public/series?limit=100&apikey=12345678&ts=") -> {
                    MockResponse().setResponseFromFile("series/series.json")
                }

                request.path!!.contains("/series/18454") -> {
                    MockResponse().setResponseFromFile("series/seriesById.json")
                }
//                STORIES
                request.path!!.contains("/stories/7/characters") -> {
                    MockResponse().setResponseFromFile("stories/storiesCharacters.json")
                }

                request.path!!.contains("/stories/7/comics") -> {
                    MockResponse().setResponseFromFile("stories/storiesComics.json")
                }

                request.path!!.contains("/stories/7/creators") -> {
                    MockResponse().setResponseFromFile("stories/storiesCreators.json")
                }

                request.path!!.contains("/stories/7/events") -> {
                    MockResponse().setResponseFromFile("stories/storiesEvents.json")
                }

                request.path!!.contains("/stories/7/series") -> {
                    MockResponse().setResponseFromFile("stories/storiesSeries.json")
                }

                request.path!!.contains("/stories") -> {
                    MockResponse().setResponseFromFile("stories/stories.json")
                }

                request.path!!.contains("/stories/7") -> {
                    MockResponse().setResponseFromFile("stories/storiesById.json")
                }

                else -> {
                    println("<--ELSE ERROR ${request.path} ")
                    MockResponse().setResponseCode(404)
                }
            }
        } else {
            MockResponse().setResponseCode(404)
        }
    }

    private fun MockResponse.setResponseFromFile(fileName: String): MockResponse {
        try {
            val inputStream =
                InstrumentationRegistry.getInstrumentation().context.assets.open(fileName)
            val builder = StringBuilder()
            InputStreamReader(inputStream, StandardCharsets.UTF_8)
                .readLines().forEach { builder.append(it) }
            return setBody(builder.toString())
        } catch (e: IOException) {
            throw e
        }
    }
}