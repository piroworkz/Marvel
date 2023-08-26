package com.luna.marvel.app.data.remote.builders

import androidx.lifecycle.SavedStateHandle
import com.luna.data.repositories.StoriesRepository
import com.luna.data.sources.StoriesDataSource
import com.luna.marvel.app.data.remote.datasources.FakeRemoteStoriesDataSource
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.stories.characters.StoryCharactersViewModel
import com.luna.marvel.app.ui.screens.stories.comics.StoryComicsViewModel
import com.luna.marvel.app.ui.screens.stories.creators.StoryCreatorsViewModel
import com.luna.marvel.app.ui.screens.stories.detail.StoryDetailViewModel
import com.luna.marvel.app.ui.screens.stories.events.StoryEventsViewModel
import com.luna.marvel.app.ui.screens.stories.master.StoriesViewModel
import com.luna.marvel.app.ui.screens.stories.series.StorySeriesViewModel
import com.luna.usecases.stories.GetCharactersByStoryIdUseCase
import com.luna.usecases.stories.GetComicsByStoryIdUseCase
import com.luna.usecases.stories.GetCreatorsByStoryIdUseCase
import com.luna.usecases.stories.GetEventsByStoryIdUseCase
import com.luna.usecases.stories.GetSeriesByStoryIdUseCase
import com.luna.usecases.stories.GetStoriesUseCase
import com.luna.usecases.stories.GetStoryByIdUseCase

class StoriesViewModelsBuilder {
    private val datasource: StoriesDataSource = FakeRemoteStoriesDataSource()
    private val repository = StoriesRepository(datasource)
    private val getStories = GetStoriesUseCase(repository)
    private val getStoryById = GetStoryByIdUseCase(repository)
    private val getCharactersByStoryId = GetCharactersByStoryIdUseCase(repository)
    private val getComicsByStoryId = GetComicsByStoryIdUseCase(repository)
    private val getCreatorsByStoryId = GetCreatorsByStoryIdUseCase(repository)
    private val getEventsByStoryId = GetEventsByStoryIdUseCase(repository)
    private val getSeriesByStoryId = GetSeriesByStoryIdUseCase(repository)

    fun storiesViewModel() = StoriesViewModel(getStories)

    fun storyDetailViewModel(id: Int = 1): StoryDetailViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return StoryDetailViewModel(savedStateHandle, getStoryById)
    }

    fun storyCharactersViewModel(id: Int = 1): StoryCharactersViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return StoryCharactersViewModel(savedStateHandle, getCharactersByStoryId)
    }

    fun storyComicsViewModel(id: Int = 1): StoryComicsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return StoryComicsViewModel(savedStateHandle, getComicsByStoryId)
    }

    fun storyCreatorsViewModel(id: Int = 1): StoryCreatorsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return StoryCreatorsViewModel(savedStateHandle, getCreatorsByStoryId)
    }

    fun storyEventsViewModel(id: Int = 1): StoryEventsViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return StoryEventsViewModel(savedStateHandle, getEventsByStoryId)
    }

    fun storySeriesViewModel(id: Int = 1): StorySeriesViewModel {
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return StorySeriesViewModel(savedStateHandle, getSeriesByStoryId)
    }
}