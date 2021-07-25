package com.pignasoft.feature.tasks.data

import com.pignasoft.dotasks.app.data.cache.dao.TaskDao
import com.pignasoft.feature.tasks.domain.model.Task
import com.pignasoft.feature.tasks.domain.model.toTask
import com.pignasoft.feature.tasks.domain.repository.TaskRepository

class TaskRepositoryImp(private val taskDao: TaskDao) : TaskRepository {

    override suspend fun getTaskList(): List<Task> = taskDao.getTasks().map { it.toTask() }
}