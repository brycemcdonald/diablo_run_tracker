package io.yeti.diablotracker.ui.start_run

import io.yeti.diablotracker.domain.models.Run

data class StartRunState(
    val run : Run = Run.getRun()
)
