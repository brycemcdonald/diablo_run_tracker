package io.yeti.diablotracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.yeti.diablotracker.data.entity.RunEntity


@Database(entities = [RunEntity::class], version = 1)
abstract class TrackerDataBase : RoomDatabase() {
    abstract fun runDao(): RunDao

    companion object {
        private const val DATABASE_NAME = "tracker_database"
        @Volatile
        private var instance: TrackerDataBase? = null

        fun getInstance(context: Context): TrackerDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TrackerDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                TrackerDataBase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}
