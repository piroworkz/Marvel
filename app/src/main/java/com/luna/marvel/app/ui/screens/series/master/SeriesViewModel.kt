package com.luna.marvel.app.ui.screens.series.master

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luna.domain.AppError
import com.luna.domain.MarvelItem
import com.luna.marvel.app.data.isEmpty
import com.luna.marvel.app.data.toAppError
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.usecases.series.GetSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getSeriesUseCase: GetSeriesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getSeries()
    }

    data class State(
        val loading: Boolean = false,
        val appError: AppError? = null,
        val series: List<MarvelItem> = emptyList(),
        val navigateUp: Boolean = false,
        val destination: Destination? = null,
        val id: Int? = null
    )

    fun sendEvent(event: MarvelEvent) {
        when (event) {
            is MarvelEvent.NavigateTo -> setNavigate(event.destination, event.itemId)
            MarvelEvent.NavigateUp -> setNavigateUp()
            MarvelEvent.ResetAppError -> resetAppError()
        }
    }

    private fun resetAppError() =
        _state.update { s -> s.copy(appError = null) }

    private fun setNavigateUp() =
        _state.update { s -> s.copy(navigateUp = !s.navigateUp) }

    private fun setNavigate(destination: Destination?, itemId: Int?) =
        _state.update { s -> s.copy(destination = destination, id = itemId) }

    private fun getSeries() {
        dataDownload {
            getSeriesUseCase().fold(
                ifLeft = { _state.update { s -> s.copy(appError = it) } },
                ifRight = { _state.update { s -> s.copy(series = it, appError = it.isEmpty) } }
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