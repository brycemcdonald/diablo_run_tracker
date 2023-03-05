package io.yeti.diablotracker.domain.repository

import io.yeti.diablotracker.domain.models.Run
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRunRepository : RunRepository {

    private val runs = mutableListOf<Run>()
    override suspend fun getAllRuns(): Flow<List<Run>> {
        return flow { emit( runs ) }
    }

    override suspend fun getSingleRun(runId: Int) : Run? {
        return runs.find { it.id == runId }
    }

    override suspend fun deleteRun(run: Run) {
        runs.remove(run)
    }

    override suspend fun updateRun(run: Run) {
        runs.add(run)
    }
}
