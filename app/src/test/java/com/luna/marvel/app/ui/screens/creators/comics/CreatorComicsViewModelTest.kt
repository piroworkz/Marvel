package com.luna.marvel.app.ui.screens.creators.comics

import androidx.lifecycle.SavedStateHandle
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.testshared.fakeComics
import com.luna.usecases.characters.GetCharacterComicsByIdUseCase
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CreatorComicsViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getCreatorComicsByIdUseCase: GetCharacterComicsByIdUseCase

    private val state = CreatorComicsViewModel.State()
    private val comics = fakeComics

}