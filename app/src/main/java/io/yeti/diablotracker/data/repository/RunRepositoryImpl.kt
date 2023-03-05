package io.yeti.diablotracker.data.repository

import io.yeti.diablotracker.data.local.RunDao
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.repository.RunRepository
import kotlinx.coroutines.flow.Flow

class RunRepositoryImpl(dao: RunDao) : RunRepository {
    override suspend fun getAllRuns(): Flow<List<Run>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleRun(runId: Int): Run? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRun(run: Run) {
        TODO("Not yet implemented")
    }

    override suspend fun updateRun(run: Run) {
        TODO("Not yet implemented")
    }

}
