package io.yeti.diablotracker.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import io.yeti.diablotracker.data.local.RunDao
import io.yeti.diablotracker.data.mapper.toRun
import io.yeti.diablotracker.data.mapper.toRunEntity
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.repository.RunRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class RunRepositoryImpl(
    private val dao: RunDao
) : RunRepository {

    override fun getAllRuns(): Flow<List<Run>> {
        return dao.getAllRuns().map { run ->
            run.map { it.toRun() }
        }
    }

    override suspend fun getAllRunList(): List<Run> {
        return dao.getAllRunsList().map { it.toRun() }
    }


    override suspend fun insertRun(run: Run) {
        Log.i("Select Run", "Inserting Run $run")
        dao.insert(run.toRunEntity())
    }

    override fun getSingleRun(runId: Int): Flow<Run> {
       return dao.getRunById(runId).map { it.toRun() }
    }
    override suspend fun deleteRun(run: Run) {
        dao.delete(run.toRunEntity())
    }


    override suspend fun updateRun(run: Run) {
        dao.update(run.toRunEntity())
    }

}
