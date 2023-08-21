package com.luna.marvel.app.ui.screens.creators.stories

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luna.domain.AppError
import com.luna.domain.Story
import com.luna.marvel.app.data.isEmpty
import com.luna.marvel.app.data.toAppError
import com.luna.marvel.app.ui.navigation.utils.Args
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.usecases.creators.GetStoriesByCreatorIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatorStoriesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getStoriesByCreatorIdUseCase: GetStoriesByCreatorIdUseCase
) : ViewModel() {

    private val creatorId: Int = savedStateHandle.get<Int>(Args.ItemId.args.first) ?: 0

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getEvents()
    }

    data class State(
        val loading: Boolean = false,
        val appError: AppError? = null,
        val events: List<Story> = emptyList(),
        val navigateUp: Boolean = false
    )

    fun sendEvent(event: AppEvent) {
        when (event) {
            AppEvent.NavigateUp -> setNavigateUp()
            AppEvent.ResetAppError -> resetAppError()
        }
    }

    private fun resetAppError() =
        _state.update { s -> s.copy(appError = null) }

    private fun setNavigateUp() =
        _state.update { s -> s.copy(navigateUp = !s.navigateUp) }

    private fun getEvents() {
        dataDownload {
            getStoriesByCreatorIdUseCase(creatorId = creatorId).fold(
                ifLeft = { _state.update { s -> s.copy(appError = it) } },
                ifRight = { _state.update { s -> s.copy(events = it, appError = it.isEmpty) } }
            )
        }
    }

    private fun dataDownload(body: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                toggleLoading()
                body()
            } catch (e: Exception) {
                _state.update { s -> s.copy(appError = e.toAppError()) }
            } finally {
                toggleLoading()
            }
        }
    }

    private fun toggleLoading() {
        _state.update { s -> s.copy(loading = !s.loading) }
    }

}