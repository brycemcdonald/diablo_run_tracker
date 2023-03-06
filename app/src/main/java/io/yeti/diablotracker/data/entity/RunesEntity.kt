package io.yeti.diablotracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.yeti.diablotracker.domain.models.Runes
import java.time.LocalDateTime


@Entity(tableName = "runes_entity")
data class RunesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val runFoundIn : Int,
    val name: String,
    val overallCount: Int,
)
