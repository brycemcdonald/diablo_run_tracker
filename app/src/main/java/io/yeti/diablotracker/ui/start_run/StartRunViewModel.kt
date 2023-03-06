package io.yeti.diablotracker.ui.start_run

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.use_case.AppUseCases
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartRunViewModel @Inject constructor(
    //savedStateHandle: SavedStateHandle,
    private val appUseCases: AppUseCases
) : ViewModel() {

    // private val runId: Int = checkNotNull(savedStateHandle["runId"])


    var state by mutableStateOf(StartRunState())
        private set


    fun onEvent(event: StartRunEvent) {
        when (event) {
            StartRunEvent.OnRunFinished -> {
                updateRun()
            }
        }
    }

    fun getIndividualRun(runId: Int) {
        appUseCases.getSingleRunUseCase.invoke(runId).map {
            Log.i("StartRunViewModel", "Run Found : $it")
            state = state.copy(run = it)
        }.launchIn(viewModelScope)
    }

    private fun updateRun() {
        val currentRunAmount = state.run.runAmounts + 1
        state = state.copy(run = state.run.copy(runAmounts = currentRunAmount))
        viewModelScope.launch(IO) {
            appUseCases.updateRunUseCase.invoke(state.run)
        }
    }


}