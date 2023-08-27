package com.luna.marvel.app.ui.builders

import androidx.lifecycle.SavedStateHandle
import com.luna.data.repositories.ComicsRepository
import com.luna.data.sources.ComicsDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteComicsDataSource
import com.luna.marvel.app.data.remote.services.ComicsService
import com.luna.marvel.app.data.remote.services.FakeComicsService
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.comics.characters.ComicCharactersViewModel
import com.luna.marvel.app.ui.screens.comics.creators.ComicCreatorsViewModel
import com.luna.marvel.app.ui.screens.comics.detail.ComicDetailViewModel
import com.luna.marvel.app.ui.screens.comics.events.ComicEventsViewModel
import com.luna.marvel.app.ui.screens.comics.master.ComicsViewModel
import com.luna.marvel.app.ui.screens.comics.stories.ComicStoriesViewModel
import com.luna.usecases.comics.GetComicByIdUseCase
import com.luna.usecases.comics.GetComicCharactersByIdUseCase
import com.luna.usecases.comics.GetComicCreatorsByIdUseCase
import com.luna.usecases.comics.GetComicEventsByIdUseCase
import com.luna.usecases.comics.GetComicStoriesByIdUseCase
import com.luna.usecases.comics.GetComicsUseCase

class ComicsViewModelsBuilder {

    private val service: ComicsService = FakeComicsService()
    private val dataSource: ComicsDataSource = RemoteComicsDataSource(service)
    private val repository = ComicsRepository(dataSource)
    private val getComicsUseCase = GetComicsUseCase(repository)
    private val getComicByIdUseCase = GetComicByIdUseCase(repository)
    private val getComicCharactersByIdUseCase = GetComicCharactersByIdUseCase(repository)
    private val getComicCreatorsByIdUseCase = GetComicCreatorsByIdUseCase(repository)
    private val getComicEventsByIdUseCase = GetComicEventsByIdUseCase(repository)
    private val getComicStoriesByIdUseCase = GetComicStoriesByIdUseCase(repository)

    fun comicsViewModel(): ComicsViewModel =
        ComicsViewModel(getComicsUseCase)

    fun comicCharactersViewModel(id: Int = 1): ComicCharactersViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return ComicCharactersViewModel(savedStateHandle, getComicCharactersByIdUseCase)
    }

    fun comicCreatorsViewModel(id: Int = 1): ComicCreatorsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return ComicCreatorsViewModel(savedStateHandle, getComicCreatorsByIdUseCase)
    }

    fun comicDetailViewModel(id: Int = 1): ComicDetailViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return ComicDetailViewModel(savedStateHandle, getComicByIdUseCase)
    }

    fun comicEventsViewModel(id: Int = 1): ComicEventsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return ComicEventsViewModel(savedStateHandle, getComicEventsByIdUseCase)
    }

    fun comicStoriesViewModel(id: Int = 1): ComicStoriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return ComicStoriesViewModel(savedStateHandle, getComicStoriesByIdUseCase)
    }

}