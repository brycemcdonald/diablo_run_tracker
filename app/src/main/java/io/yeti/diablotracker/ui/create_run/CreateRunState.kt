package io.yeti.diablotracker.ui.create_run

import io.yeti.diablotracker.domain.models.Run

data class CreateRunState(
    val runName : String = "",
    val playerNumber : Int = 1,
    val playerNumberList: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8),
    val isError : Boolean = false,
    val saveIsComplete : Boolean = false
)
