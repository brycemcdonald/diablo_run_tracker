package io.yeti.diablotracker.domain.use_case

import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.repository.RunRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class GetRunUseCase(
    val runRepository: RunRepository,
) {

    suspend operator fun invoke(): List<Run> {
        val allRuns = runRepository.getAllRuns()
        return allRuns.first()
    }
}


