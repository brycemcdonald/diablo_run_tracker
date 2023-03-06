package io.yeti.diablotracker.ui.start_run

import io.yeti.diablotracker.domain.models.Run

data class StartRunState(
    val runId : Int = 0,
    val runName : String = "",
    val runPlayerCount : Int = 0
)
