package io.yeti.diablotracker.data.local

import androidx.room.*
import io.yeti.diablotracker.data.entity.RunEntity

@Dao
interface RunDao {
    @Insert
    fun insert(item: RunEntity)

    @Update
    fun update(item: RunEntity)

    @Delete
    fun delete(item: RunEntity)

    @Query("SELECT * FROM run_entity")
    fun getAllItems(): List<RunEntity>

    @Query("SELECT * FROM run_entity WHERE id = :id")
    fun getItemById(id: Int): RunEntity
}
