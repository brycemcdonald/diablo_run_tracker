package io.yeti.diablotracker.ui.select_run

import io.yeti.diablotracker.domain.models.Run

data class SelectRunState(
    val runList: List<Run> = emptyList(),
)
