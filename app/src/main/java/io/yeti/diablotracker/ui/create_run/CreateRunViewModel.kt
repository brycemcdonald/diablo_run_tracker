package io.yeti.diablotracker.ui.create_run

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.use_case.AppUseCases
import io.yeti.diablotracker.ui.select_run.SelectRunState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel class CreateRunViewModel @Inject constructor(
    private val appUseCases: AppUseCases
) : ViewModel() {

    var state by mutableStateOf(CreateRunState())
        private set

    fun onEvent(event : CreateRunEvent) {
        when(event) {
            is CreateRunEvent.OnSaveClicked -> {
                if (event.nameOfRun.isNotEmpty()) {
                    state = state.copy(runName = event.nameOfRun, playerNumber = event.playerCount)
                    viewModelScope.launch(IO) {
                        appUseCases.saveRunUseCase.invoke(
                            Run(
                                createdAt = LocalDateTime.now(),
                                runAmounts = 0,
                                playerNumber = event.playerCount,
                                uniquesFound = 0,
                                setFounds = 0,
                                isFavourite = false,
                                isActive = true,
                                runesFound = arrayListOf(),
                                runeName = state.runName
                            )
                        )
                        state = state.copy(saveIsComplete = true)
                    }
                } else {
                    state = state.copy(isError = true)
                }

            }
            CreateRunEvent.SaveComplete -> {
                state = state.copy(saveIsComplete = true)
            }
            CreateRunEvent.ClearState -> {
                state = state.copy(runName = "", saveIsComplete = false, isError = false)
            }
        }
    }

}