package io.yeti.diablotracker.data.local

import androidx.room.*
import io.yeti.diablotracker.data.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {
    @Insert
    fun insert(item: RunEntity)

    @Update
    fun update(item: RunEntity)

    @Delete
    fun delete(item: RunEntity)

    @Query("SELECT * FROM run_entity")
    fun getAllRuns(): Flow<List<RunEntity>>

    @Query("SELECT * FROM run_entity")
    fun getAllRunsList(): List<RunEntity>
    @Query("SELECT * FROM run_entity WHERE id = :id")
    fun getRunById(id: Int): Flow<RunEntity>
}
