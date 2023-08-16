package com.luna.marvel.app.ui.screens.characters.master

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luna.domain.Character
import com.luna.marvel.app.ui.application.log
import com.luna.usecases.characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersMasterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        getCharacters()
    }

    data class State(
        val characters: List<Character> = emptyList()
    )


    private fun getCharacters() {
        viewModelScope.launch {
            getCharactersUseCase().fold(
                ifLeft = {},
                ifRight = {
                    it.count().toString().log("COUNT")
                    _state.update { s -> s.copy(characters = it) }
                }
            )
        }
    }
}