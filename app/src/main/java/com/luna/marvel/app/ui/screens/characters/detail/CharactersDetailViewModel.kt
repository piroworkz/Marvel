package com.luna.marvel.app.ui.screens.characters.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.marvel.app.data.toAppError
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.Args
import com.luna.usecases.characters.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {
    private val characterId: Int = savedStateHandle.get<Int>(Args.ItemId.args.first) ?: 0

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getCharacterById()
    }

    data class State(
        val loading: Boolean = false,
        val appError: AppError? = null,
        val character: Character? = null,
        val navigateUp: Boolean = false,
        val destination: Destination? = null
    )

    private fun getCharacterById() {
        dataDownload {
            getCharacterByIdUseCase(characterId).fold(
                ifLeft = { _state.update { s -> s.copy(appError = it) } },
                ifRight = {
                    _state.update { s -> s.copy(character = it.first()) }
                }
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