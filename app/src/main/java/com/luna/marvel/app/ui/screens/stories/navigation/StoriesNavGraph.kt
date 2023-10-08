package com.luna.marvel.app.ui.screens.stories.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.StoriesGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.navigation.utils.navigateFromMaster
import com.luna.marvel.app.ui.navigation.utils.navigateUpFromGraph
import com.luna.marvel.app.ui.screens.stories.characters.StoryCharactersScreen
import com.luna.marvel.app.ui.screens.stories.characters.StoryCharactersViewModel
import com.luna.marvel.app.ui.screens.stories.comics.StoryComicsScreen
import com.luna.marvel.app.ui.screens.stories.comics.StoryComicsViewModel
import com.luna.marvel.app.ui.screens.stories.creators.StoryCreatorsScreen
import com.luna.marvel.app.ui.screens.stories.creators.StoryCreatorsViewModel
import com.luna.marvel.app.ui.screens.stories.detail.StoryDetailScreen
import com.luna.marvel.app.ui.screens.stories.detail.StoryDetailViewModel
import com.luna.marvel.app.ui.screens.stories.events.StoryEventsScreen
import com.luna.marvel.app.ui.screens.stories.events.StoryEventsViewModel
import com.luna.marvel.app.ui.screens.stories.master.StoriesScreen
import com.luna.marvel.app.ui.screens.stories.master.StoriesViewModel
import com.luna.marvel.app.ui.screens.stories.series.StorySeriesScreen
import com.luna.marvel.app.ui.screens.stories.series.StorySeriesViewModel

fun NavGraphBuilder.storiesNavGraph(
    navigate: (Destination, List<Any>) -> Unit, navigateUp: () -> Unit
) {
    navigation(
        startDestination = StoriesGraph.Stories.route, route = StoriesGraph.Init.route
    ) {

        navComposable(StoriesGraph.Stories) { viewModel: StoriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                isNavigateUp = state.navigateUp,
                destination = state.destination,
                arg = state.id,
                onNavigateUp = navigateUp,
                sendEvent = viewModel::sendEvent,
                navigate = navigate
            )
            StoriesScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(StoriesGraph.StoriesDetail) { viewModel: StoryDetailViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            StoryDetailScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(StoriesGraph.StoriesCharacters) { viewModel: StoryCharactersViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            StoryCharactersScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(StoriesGraph.StoriesComics) { viewModel: StoryComicsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            StoryComicsScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(StoriesGraph.StoriesCreators) { viewModel: StoryCreatorsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            StoryCreatorsScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(StoriesGraph.StoriesEvents) { viewModel: StoryEventsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            StoryEventsScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(StoriesGraph.StoriesSeries) { viewModel: StorySeriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            StorySeriesScreen(state = state, sendEvent = viewModel::sendEvent)
        }

    }

}

