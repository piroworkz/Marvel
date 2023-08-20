package com.luna.marvel.app.ui.screens.characters.master

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luna.domain.AppError
import com.luna.domain.MarvelItem
import com.luna.marvel.app.data.toAppError
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.master.MarvelEvent
import com.luna.usecases.characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getCharacters()
    }

    data class State(
        val loading: Boolean = false,
        val error: AppError? = null,
        val characters: List<MarvelItem> = emptyList(),
        val navigateUp: Boolean = false,
        val destination: Destination? = null,
        val characterId: Int? = null
    )

    fun sendEvent(event: MarvelEvent) {
        when (event) {
            is MarvelEvent.NavigateTo -> setNavigate(event)
            MarvelEvent.NavigateUp -> setNavigateUp()
        }
    }

    private fun setNavigateUp() {
        _state.update { s -> s.copy(navigateUp = !s.navigateUp) }
    }

    private fun setNavigate(event: MarvelEvent.NavigateTo) {
        _state.update { s ->
            s.copy(
                destination = event.destination,
                characterId = event.itemId
            )
        }
    }

    private fun getCharacters() {
        dataDownload {
            getCharactersUseCase().fold(
                ifLeft = { _state.update { s -> s.copy(error = it) } },
                ifRight = { _state.update { s -> s.copy(characters = it) } }
            )
        }
    }

    private fun dataDownload(body: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                toggleLoading()
                body()
            } catch (e: Exception) {
                _state.update { s -> s.copy(error = e.toAppError()) }
            } finally {
                toggleLoading()
            }
        }
    }

    private fun toggleLoading() {
        _state.update { s -> s.copy(loading = !s.loading) }
    }
}