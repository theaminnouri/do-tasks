package com.pignasoft.feature.addTask.domain.repository

import com.pignasoft.feature.addTask.domain.model.TaskDomainModel

interface AddTaskRepository {
    suspend fun add(task: TaskDomainModel): Long
}
