package com.pignasoft.dotasks.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pignasoft.dotasks.data.cache.dao.TaskDao
import com.pignasoft.dotasks.data.cache.model.TaskEntity

@TypeConverters(Converters::class)
@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {
        const val APP_DATABASE_NAME = "DO_TASKS_DATABASE"
    }
}
