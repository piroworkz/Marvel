package com.luna.marvel.app.data.remote.builders

import androidx.lifecycle.SavedStateHandle
import com.luna.data.repositories.EventsRepository
import com.luna.data.sources.EventsDataSource
import com.luna.marvel.app.data.remote.datasources.FakeRemoteEventsDataSource
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.events.characters.EventCharactersViewModel
import com.luna.marvel.app.ui.screens.events.comics.EventComicsViewModel
import com.luna.marvel.app.ui.screens.events.creators.EventCreatorsViewModel
import com.luna.marvel.app.ui.screens.events.detail.EventDetailViewModel
import com.luna.marvel.app.ui.screens.events.master.EventsViewModel
import com.luna.marvel.app.ui.screens.events.series.EventSeriesViewModel
import com.luna.marvel.app.ui.screens.events.stories.EventStoriesViewModel
import com.luna.usecases.events.GetCharactersByEventIdUseCase
import com.luna.usecases.events.GetComicsByEventIdUseCase
import com.luna.usecases.events.GetCreatorsByEventIdUseCase
import com.luna.usecases.events.GetEventByIdUseCase
import com.luna.usecases.events.GetEventsUseCase
import com.luna.usecases.events.GetSeriesByEventIdUseCase
import com.luna.usecases.events.GetStoriesByEventIdUseCase

class EventsViewModelsBuilder {
    private val eventsDataSource: EventsDataSource = FakeRemoteEventsDataSource()
    private val repository = EventsRepository(eventsDataSource)
    private val getEvents = GetEventsUseCase(repository)
    private val getEventByIdUseCase = GetEventByIdUseCase(repository)
    private val getCharactersByEventIdUseCase = GetCharactersByEventIdUseCase(repository)
    private val getComicsByEventIdUseCase = GetComicsByEventIdUseCase(repository)
    private val getCreatorsByEventIdUseCase = GetCreatorsByEventIdUseCase(repository)
    private val getSeriesByEventIdUseCase = GetSeriesByEventIdUseCase(repository)
    private val getStoriesByEventIdUseCase = GetStoriesByEventIdUseCase(repository)

    fun eventsViewModel() = EventsViewModel(getEvents)

    fun eventCharactersViewModel(id: Int = 1): EventCharactersViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return EventCharactersViewModel(savedStateHandle, getCharactersByEventIdUseCase)
    }

    fun eventComicsViewModel(id: Int = 1): EventComicsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return EventComicsViewModel(savedStateHandle, getComicsByEventIdUseCase)
    }

    fun eventCreatorsViewModel(id: Int = 1): EventCreatorsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return EventCreatorsViewModel(savedStateHandle, getCreatorsByEventIdUseCase)
    }

    fun eventDetailViewModel(id: Int = 1): EventDetailViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return EventDetailViewModel(savedStateHandle, getEventByIdUseCase)
    }

    fun eventSeriesViewModel(id: Int = 1): EventSeriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return EventSeriesViewModel(savedStateHandle, getSeriesByEventIdUseCase)
    }

    fun eventStoriesViewModel(id: Int = 1): EventStoriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return EventStoriesViewModel(savedStateHandle, getStoriesByEventIdUseCase)
    }
}