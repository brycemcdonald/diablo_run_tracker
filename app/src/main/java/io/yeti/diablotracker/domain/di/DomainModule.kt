package io.yeti.diablotracker.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.yeti.diablotracker.domain.repository.RunRepository
import io.yeti.diablotracker.domain.use_case.AppUseCases
import io.yeti.diablotracker.domain.use_case.GetRunUseCase
import io.yeti.diablotracker.domain.use_case.SaveRunUseCase
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideAppUseCases (rep : RunRepository) : AppUseCases {
        return AppUseCases(
            getRunUseCase = GetRunUseCase(rep),
            saveRunUseCase = SaveRunUseCase(rep)
        )
    }

}
