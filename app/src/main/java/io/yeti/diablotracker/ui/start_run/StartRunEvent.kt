package io.yeti.diablotracker.ui.start_run

import io.yeti.diablotracker.domain.models.Run

sealed class StartRunEvent {
    object OnRunFinished : StartRunEvent()

}
