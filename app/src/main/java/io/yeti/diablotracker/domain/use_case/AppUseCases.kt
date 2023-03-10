package io.yeti.diablotracker.domain.use_case

data class AppUseCases(
    val getRunUseCase: GetRunUseCase,
    val saveRunUseCase: SaveRunUseCase,
    val getSingleRunUseCase: GetSingleRunUseCase,
    val updateRunUseCase: UpdateRunUseCase
)
