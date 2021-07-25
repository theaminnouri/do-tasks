package com.pignasoft.feature.tasks.domain.usecase

import com.pignasoft.dotasks.base.presentation.domain.Result
import com.pignasoft.feature.tasks.domain.repository.TaskRepository
import java.io.IOException

class GetTaskListUseCase(private val taskRepository: TaskRepository) {

    suspend fun execute(): Result {
        return try {
            Result.Success(taskRepository.getTaskList())
        } catch (e: IOException) {
            Result.Error(e)
        }
    }
}