package com.pignasoft.feature.tasks.domain.model

import com.pignasoft.dotasks.app.data.cache.model.TaskType

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val remind_at: String = "",
    val completed: Boolean? = null,
    val type: TaskType = TaskType.ONE_TIME,
    val expected_duration: Long = 0,
    val duration: Long = 0,
    val days: List<String> = listOf(),
    val create_date: Long = 0,
    val update_date: Long = 0
)
