package com.pignasoft.feature_add.domain.repository

import com.pignasoft.feature_add.domain.model.TaskDomainModel

interface AddTaskRepository {
    suspend fun add(task: TaskDomainModel): Long
}