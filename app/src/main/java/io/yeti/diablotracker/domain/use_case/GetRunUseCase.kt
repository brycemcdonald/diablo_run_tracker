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

class GetRunUseCase(
    private val runRepository: RunRepository,
) {

    operator fun invoke(): Flow<List<Run>> {
//        CoroutineScope(IO).launch {
//           Log.i("Select Run Get Run Use Case:", "${runRepository.getAllRunList().size}")
//        }
//        Log.i("Select Run Get Run Use Case:", "${runRepository.getAllRuns()}")
        return runRepository.getAllRuns()

    }
}


