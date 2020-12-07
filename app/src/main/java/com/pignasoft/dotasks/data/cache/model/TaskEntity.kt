package com.pignasoft.dotasks.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val description: String,
    val remind_at: String = "",
    val completed: Boolean? = null,
    val type: TaskType = TaskType.DOABLE,
    val expected_duration: Long = 0,
    val duration: Long = 0,
    val days: List<String> = listOf(),
    val create_date: Long = 0,
    val update_date: Long = 0
)
