package com.luna.marvel.app.ui.builders

import androidx.lifecycle.SavedStateHandle
import com.luna.data.repositories.CharactersRepository
import com.luna.data.sources.CharactersDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteCharactersDataSource
import com.luna.marvel.app.data.remote.services.CharactersService
import com.luna.marvel.app.data.remote.services.FakeCharactersService
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.characters.comics.CharactersComicsViewModel
import com.luna.marvel.app.ui.screens.characters.detail.CharactersDetailViewModel
import com.luna.marvel.app.ui.screens.characters.events.CharacterEventsViewModel
import com.luna.marvel.app.ui.screens.characters.master.CharactersViewModel
import com.luna.marvel.app.ui.screens.characters.series.CharacterSeriesViewModel
import com.luna.marvel.app.ui.screens.characters.stories.CharacterStoriesViewModel
import com.luna.usecases.characters.GetCharacterByIdUseCase
import com.luna.usecases.characters.GetCharacterComicsByIdUseCase
import com.luna.usecases.characters.GetCharacterEventsByIdUseCase
import com.luna.usecases.characters.GetCharacterSeriesByIdUseCase
import com.luna.usecases.characters.GetCharacterStoriesByIdUseCase
import com.luna.usecases.characters.GetCharactersUseCase

class CharactersViewModelsBuilder {

    private val service: CharactersService = FakeCharactersService()
    private val dataSource: CharactersDataSource = RemoteCharactersDataSource(service)
    private val repository: CharactersRepository = CharactersRepository(dataSource)
    private val getCharacters = GetCharactersUseCase(repository)
    private val getCharacterById = GetCharacterByIdUseCase(repository)
    private val getCharacterComicsById = GetCharacterComicsByIdUseCase(repository)
    private val getCharacterEventsById = GetCharacterEventsByIdUseCase(repository)
    private val getCharacterSeriesById = GetCharacterSeriesByIdUseCase(repository)
    private val getCharacterStoriesById = GetCharacterStoriesByIdUseCase(repository)

    fun charactersViewModel() =
        CharactersViewModel(getCharacters)

    fun charactersDetailViewModel(id: Int = 1): CharactersDetailViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CharactersDetailViewModel(savedStateHandle, getCharacterById)
    }

    fun charactersComicsViewModel(id: Int = 1): CharactersComicsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CharactersComicsViewModel(savedStateHandle, getCharacterComicsById)
    }

    fun charactersEventsViewModel(id: Int = 1): CharacterEventsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CharacterEventsViewModel(savedStateHandle, getCharacterEventsById)
    }

    fun charactersSeriesViewModel(id: Int = 1): CharacterSeriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CharacterSeriesViewModel(savedStateHandle, getCharacterSeriesById)
    }

    fun charactersStoriesViewModel(id: Int = 1): CharacterStoriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CharacterStoriesViewModel(savedStateHandle, getCharacterStoriesById)
    }

}