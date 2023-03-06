package io.yeti.diablotracker.domain.use_case

import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.repository.RunRepository

class UpdateRunUseCase(
    private val runRepository: RunRepository,
) {
    suspend operator fun invoke(run : Run) {
        runRepository.updateRun(run)
    }

}