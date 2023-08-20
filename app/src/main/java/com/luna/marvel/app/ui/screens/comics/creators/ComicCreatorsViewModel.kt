package com.luna.marvel.app.ui.screens.comics.creators

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luna.domain.AppError
import com.luna.domain.Creator
import com.luna.marvel.app.data.toAppError
import com.luna.marvel.app.ui.navigation.utils.Args
import com.luna.usecases.comics.GetComicCreatorsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicCreatorsViewModel @Inject constructor(
    private val getComicCreatorsByIdUseCase: GetComicCreatorsByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val comicId: Int = savedStateHandle.get<Int>(Args.ItemId.args.first) ?: 0

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getComics()
    }

    data class State(
        val loading: Boolean = false,
        val appError: AppError? = null,
        val characters: List<Creator> = emptyList(),
        val navigateUp: Boolean = false
    )

    fun toggleNavigateUp() {
        _state.update { s -> s.copy(navigateUp = !s.navigateUp) }
    }

    private fun getComics() {
        dataDownload {
            getComicCreatorsByIdUseCase(comicId).fold(
                ifLeft = { _state.update { s -> s.copy(appError = it) } },
                ifRight = { _state.update { s -> s.copy(characters = it, navigateUp = it.isEmpty()) } }
            )
        }
    }

    private fun dataDownload(body: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                _state.update { s -> s.copy(loading = true) }
                body()
            } catch (e: Exception) {
                _state.update { s -> s.copy(appError = e.toAppError()) }
            } finally {
                _state.update { s -> s.copy(loading = false) }
            }
        }
    }

}