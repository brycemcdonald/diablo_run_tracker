package io.yeti.diablotracker.data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.yeti.diablotracker.data.local.TrackerDataBase
import io.yeti.diablotracker.data.repository.RunRepositoryImpl
import io.yeti.diablotracker.domain.repository.RunRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTrackerDatabase(app: Application): TrackerDataBase {
        return Room.databaseBuilder(
            app,
            TrackerDataBase::class.java,
            "diablo_tracker_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTrackerRepository(
        db: TrackerDataBase
    ): RunRepository {
        return RunRepositoryImpl(
            dao = db.runDao()
        )
    }
}