package com.luna.marvel.app.ui.builders

import androidx.lifecycle.SavedStateHandle
import com.luna.data.repositories.SeriesRepository
import com.luna.data.sources.SeriesDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteSeriesDataSource
import com.luna.marvel.app.data.remote.services.FakeSeriesService
import com.luna.marvel.app.data.remote.services.SeriesService
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.series.characters.SeriesCharactersViewModel
import com.luna.marvel.app.ui.screens.series.comics.SeriesComicsViewModel
import com.luna.marvel.app.ui.screens.series.creators.SeriesCreatorsViewModel
import com.luna.marvel.app.ui.screens.series.detail.SeriesDetailViewModel
import com.luna.marvel.app.ui.screens.series.events.SeriesEventsViewModel
import com.luna.marvel.app.ui.screens.series.master.SeriesViewModel
import com.luna.marvel.app.ui.screens.series.stories.SeriesStoriesViewModel
import com.luna.usecases.series.GetCharactersBySeriesIdUseCase
import com.luna.usecases.series.GetComicsBySeriesIdUseCase
import com.luna.usecases.series.GetCreatorsBySeriesIdUseCase
import com.luna.usecases.series.GetEventsBySeriesIdUseCase
import com.luna.usecases.series.GetSeriesByIdUseCase
import com.luna.usecases.series.GetSeriesUseCase
import com.luna.usecases.series.GetStoriesBySeriesIdUseCase

class SeriesViewModelsBuilder {

    private val service: SeriesService = FakeSeriesService()
    private val datasource: SeriesDataSource = RemoteSeriesDataSource(service)
    private val repository = SeriesRepository(datasource)
    private val getSeries = GetSeriesUseCase(repository)
    private val getSeriesById = GetSeriesByIdUseCase(repository)
    private val getCharactersBySeriesId = GetCharactersBySeriesIdUseCase(repository)
    private val getComicsBySeriesId = GetComicsBySeriesIdUseCase(repository)
    private val getCreatorsBySeriesId = GetCreatorsBySeriesIdUseCase(repository)
    private val getEventsBySeriesId = GetEventsBySeriesIdUseCase(repository)
    private val getStoriesBySeriesId = GetStoriesBySeriesIdUseCase(repository)

    fun buildSeriesViewModel() = SeriesViewModel(getSeries)

    fun buildSeriesDetailViewModel(id: Int = 1): SeriesDetailViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return SeriesDetailViewModel(savedStateHandle, getSeriesById)
    }

    fun buildSeriesComicsViewModel(id: Int = 1): SeriesComicsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return SeriesComicsViewModel(savedStateHandle, getComicsBySeriesId)
    }

    fun buildSeriesCharactersViewModel(id: Int = 1): SeriesCharactersViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return SeriesCharactersViewModel(savedStateHandle, getCharactersBySeriesId)
    }

    fun buildSeriesCreatorsViewModel(id: Int = 1): SeriesCreatorsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return SeriesCreatorsViewModel(savedStateHandle, getCreatorsBySeriesId)
    }

    fun buildSeriesEventsViewModel(id: Int = 1): SeriesEventsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return SeriesEventsViewModel(savedStateHandle, getEventsBySeriesId)
    }

    fun buildSeriesStoriesViewModel(id: Int = 1): SeriesStoriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return SeriesStoriesViewModel(savedStateHandle, getStoriesBySeriesId)
    }

}