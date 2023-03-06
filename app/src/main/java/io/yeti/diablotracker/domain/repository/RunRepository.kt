package io.yeti.diablotracker.domain.repository

import io.yeti.diablotracker.domain.models.Run
import kotlinx.coroutines.flow.Flow

interface RunRepository {


    suspend fun insertRun(run : Run)
    fun getAllRuns () : Flow<List<Run>>

    suspend fun getAllRunList () : List<Run>
    fun getSingleRun(runId : Int) : Flow<Run>
    suspend fun deleteRun(run : Run)
    suspend fun updateRun(run : Run)

}
