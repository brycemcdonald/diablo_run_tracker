package io.yeti.diablotracker.domain.repository

import io.yeti.diablotracker.domain.models.Run
import kotlinx.coroutines.flow.Flow

interface RunRepository {

    suspend fun getAllRuns () : Flow<List<Run>>
    suspend fun getSingleRun(runId : Int) : Run?
    suspend fun deleteRun(run : Run)
    suspend fun updateRun(run : Run)

}
