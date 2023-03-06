package io.yeti.diablotracker.ui.select_run

import io.yeti.diablotracker.domain.models.Run

sealed class SelectRunEvent {
    object OnFloatingAction : SelectRunEvent()
    data class OnRunSelect(val run : Run) : SelectRunEvent()

}
