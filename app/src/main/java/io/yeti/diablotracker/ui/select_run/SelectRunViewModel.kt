package io.yeti.diablotracker.ui.select_run

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.yeti.diablotracker.domain.use_case.AppUseCases
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectRunViewModel @Inject constructor(
    private val appUseCases: AppUseCases
) : ViewModel()  {

    var state by mutableStateOf(SelectRunState())
        private set

//    private val _state = mutableStateOf(SelectRunState())
//    val state: State<SelectRunState> = _state
    init {
        getRuns()
    }


    fun onEvent(event : SelectRunEvent) {
        when(event) {
            SelectRunEvent.OnFloatingAction -> TODO()
            is SelectRunEvent.OnRunSelect -> TODO()
        }
    }

    private  fun getRuns() {
            appUseCases.getRunUseCase.invoke().map {
                Log.i("Select Run VM", "Run List : $it")
                state = state.copy(runList = it)
            }.launchIn(viewModelScope)


    }


}