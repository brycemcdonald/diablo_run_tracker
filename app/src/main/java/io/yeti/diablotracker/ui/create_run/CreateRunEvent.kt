package io.yeti.diablotracker.ui.create_run

import io.yeti.diablotracker.domain.models.Run

sealed class CreateRunEvent {
    object SaveComplete : CreateRunEvent()
    object ClearState : CreateRunEvent()
    data class OnSaveClicked(val nameOfRun : String, val playerCount : Int) : CreateRunEvent()

}
