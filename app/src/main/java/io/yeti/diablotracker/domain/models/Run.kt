package io.yeti.diablotracker.domain.models

import java.time.LocalDateTime

data class Run (
    val id : Int? = null,
    val runeName : String,
    val runAmounts : Int,
    val playerNumber : Int,
    val runesFound : List<Runes>,
    val uniquesFound : Int,
    val setFounds : Int,
    val isFavourite : Boolean,
    val createdAt : LocalDateTime,
    val isActive : Boolean
)
