package com.pignasoft.feature.tasks.domain.repository

import com.pignasoft.feature.tasks.domain.model.Task

interface TaskRepository {
    suspend fun getTaskList(): List<Task>
}