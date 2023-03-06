package io.yeti.diablotracker.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import io.yeti.diablotracker.data.entity.RunEntity
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.domain.models.Runes
import java.time.LocalDateTime


@RequiresApi(Build.VERSION_CODES.O)
fun Run.toRunEntity () : RunEntity {
    return RunEntity(
        id = id,
        name = runeName,
        count = runAmounts,
        active = isActive,
        isFavourite = isFavourite,
        setsFound = setFounds,
        uniquesFound = uniquesFound,
        highRunesFound = 0,
        midRunesFound = 0,
        lowRunesFound = 0,
        createdAt = createdAt.dayOfMonth

    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun RunEntity.toRun () : Run {
    return Run(
        id = id,
        runeName = name,
        runAmounts = count,
        playerNumber = 1,
        runesFound = arrayListOf(),
        uniquesFound = uniquesFound,
        setFounds = setsFound,
        isFavourite = isFavourite,
        createdAt = LocalDateTime.now(),
        isActive = active

    )

}

