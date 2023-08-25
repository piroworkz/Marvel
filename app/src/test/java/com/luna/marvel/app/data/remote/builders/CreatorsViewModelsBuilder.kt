package com.luna.marvel.app.data.remote.builders

import androidx.lifecycle.SavedStateHandle
import com.luna.data.repositories.CreatorsRepository
import com.luna.data.sources.CreatorsDataSource
import com.luna.marvel.app.data.remote.datasources.FakeRemoteCreatorsDataSource
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.creators.comics.CreatorComicsViewModel
import com.luna.marvel.app.ui.screens.creators.detail.CreatorDetailViewModel
import com.luna.marvel.app.ui.screens.creators.events.CreatorEventsViewModel
import com.luna.marvel.app.ui.screens.creators.master.CreatorsViewModel
import com.luna.marvel.app.ui.screens.creators.series.CreatorSeriesViewModel
import com.luna.marvel.app.ui.screens.creators.stories.CreatorStoriesViewModel
import com.luna.usecases.creators.GetComicsByCreatorIdUseCase
import com.luna.usecases.creators.GetCreatorByIdUseCase
import com.luna.usecases.creators.GetCreatorsUseCase
import com.luna.usecases.creators.GetEventsByCreatorIdUseCase
import com.luna.usecases.creators.GetSeriesByCreatorIdUseCase
import com.luna.usecases.creators.GetStoriesByCreatorIdUseCase

class CreatorsViewModelsBuilder {
    private val remoteCreatorsDataSource: CreatorsDataSource = FakeRemoteCreatorsDataSource()
    private val repository = CreatorsRepository(remoteCreatorsDataSource)
    private val getCreators = GetCreatorsUseCase(repository)
    private val getCreatorById = GetCreatorByIdUseCase(repository)
    private val getComicsByCreatorId = GetComicsByCreatorIdUseCase(repository)
    private val getEventsByCreatorId = GetEventsByCreatorIdUseCase(repository)
    private val getSeriesByCreatorId = GetSeriesByCreatorIdUseCase(repository)
    private val getStoriesByCreatorId = GetStoriesByCreatorIdUseCase(repository)

    fun creatorsViewModel() =
        CreatorsViewModel(getCreators)

    fun creatorsDetailViewModel(id: Int = 1): CreatorDetailViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CreatorDetailViewModel(savedStateHandle, getCreatorById)
    }

    fun creatorsComicsViewModel(id: Int = 1): CreatorComicsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CreatorComicsViewModel(savedStateHandle, getComicsByCreatorId)
    }

    fun creatorsEventsViewModel(id: Int = 1): CreatorEventsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CreatorEventsViewModel(savedStateHandle, getEventsByCreatorId)
    }

    fun creatorsSeriesViewModel(id: Int = 1): CreatorSeriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CreatorSeriesViewModel(savedStateHandle, getSeriesByCreatorId)
    }

    fun creatorsStoriesViewModel(id: Int = 1): CreatorStoriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CreatorStoriesViewModel(savedStateHandle, getStoriesByCreatorId)
    }
}