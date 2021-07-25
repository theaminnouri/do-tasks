package com.pignasoft.feature.tasks.domain.repository

import com.pignasoft.feature.tasks.domain.model.TaskDomainModel

interface AddTaskRepository {
    suspend fun add(task: TaskDomainModel): Long
}
