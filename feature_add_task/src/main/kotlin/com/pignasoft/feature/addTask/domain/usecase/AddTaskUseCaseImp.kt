package com.pignasoft.feature.addTask.domain.usecase

import com.pignasoft.feature.addTask.domain.model.TaskDomainModel
import com.pignasoft.feature.addTask.domain.repository.AddTaskRepository

interface AddTaskUseCase {
    suspend fun add(task: TaskDomainModel): Result
}

sealed class Result {
    data class Success(val id: Long) : Result()
    data class Error(val messageResId: Int) : Result()
}

class AddTaskUseCaseImp constructor(private val repository: AddTaskRepository) {

    suspend fun add(task: TaskDomainModel): Result {
        val add = repository.add(task)
        return if (add >= 0)
            Result.Success(add)
        else
            Result.Error(com.pignasoft.dotasks.R.string.unknown_error)
    }
}
