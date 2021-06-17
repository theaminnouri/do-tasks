package com.pignasoft.dotasks.app.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.pignasoft.dotasks.app.data.cache.model.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = REPLACE)
    suspend fun add(list: List<TaskEntity>)

    @Query("SELECT * FROM TBL_TASKS")
    suspend fun getTasks(): List<TaskEntity>
}
