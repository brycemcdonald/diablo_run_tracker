package io.yeti.diablotracker.domain.models

sealed class RunesList(val runes: Runes) {
    object Nef : RunesList(Runes("NEF", LOW))
    object Ort : RunesList(Runes("Ort", LOW))
    object Amn : RunesList(Runes("Amn", LOW))
    object Ith : RunesList(Runes("Ith", LOW))
    object Tir : RunesList(Runes("Tir", LOW))

    object Lem : RunesList(Runes("Lem", MEDIUM))
    object Fal : RunesList(Runes("Fal", MEDIUM))
    object Pul : RunesList(Runes("Pul", MEDIUM))
    object Um : RunesList(Runes("Um", MEDIUM))
    object Mal : RunesList(Runes("Mal", MEDIUM))

    object Ist : RunesList(Runes("Ist", HIGH))
    object Gul : RunesList(Runes("Gul", HIGH))
    object Vex : RunesList(Runes("Vex", HIGH))
    object Ohm : RunesList(Runes("Ohm", HIGH))
    object Lo : RunesList(Runes("Lo", HIGH))
    object Sur : RunesList(Runes("Sur", HIGH))
    object Ber : RunesList(Runes("Ber", HIGH))
    object Jah : RunesList(Runes("Jah", HIGH))
    object Cham : RunesList(Runes("Cham", HIGH))
    object Zod : RunesList(Runes("Zod", HIGH))



}

data class Runes(
    val runeName : String,
    val runeRanking : Int
)

const val HIGH = 3
const val MEDIUM = 2
const val LOW = 1






