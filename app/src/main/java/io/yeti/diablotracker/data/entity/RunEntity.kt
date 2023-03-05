package io.yeti.diablotracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "run_entity")
data class RunEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val count: Int,
    val active: Boolean
)
