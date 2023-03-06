package io.yeti.diablotracker.domain.models

import java.time.LocalDateTime

data class Run (
    val id : Int? = null,
    val runName : String,
    val runAmounts : Int,
    val playerNumber : Int,
    val runesFound : List<Runes>,
    val uniquesFound : Int,
    val setFounds : Int,
    val isFavourite : Boolean,
    val createdAt : LocalDateTime,
    val isActive : Boolean
) {
    companion object {
        fun getRun(): Run {
            return Run(
                id = null,
                runName = "",
                runAmounts = 0,
                playerNumber = 0,
                runesFound = arrayListOf(),
                uniquesFound = 0,
                setFounds = 0,
                isFavourite = false,
                createdAt = LocalDateTime.now(),
                isActive = false
            )
        }
    }
}
