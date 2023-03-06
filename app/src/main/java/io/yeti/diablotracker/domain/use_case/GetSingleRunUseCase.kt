package io.yeti.diablotracker.domain.use_case

import android.util.Log
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.repository.RunRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GetSingleRunUseCase(
    private val runRepository: RunRepository,
) {

    operator fun invoke(runId : Int): Flow<Run> {
        return runRepository.getSingleRun(runId)
    }
}


