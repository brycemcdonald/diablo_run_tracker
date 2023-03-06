package io.yeti.diablotracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.yeti.diablotracker.domain.models.Runes
import java.time.LocalDateTime


@Entity(tableName = "run_entity")
data class RunEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val count: Int,
    val active: Boolean,
    val isFavourite : Boolean,
    val createdAt : Int,
    val setsFound : Int,
    val uniquesFound : Int,
    val highRunesFound : Int,
    val midRunesFound : Int,
    val lowRunesFound : Int,

)
