package com.pignasoft.feature.tasks.domain.usecase

import com.pignasoft.feature.tasks.domain.model.TaskDomainModel
import com.pignasoft.feature.tasks.domain.repository.AddTaskRepository

interface AddTaskUseCase {
    suspend fun add(task: TaskDomainModel): Result
}

sealed class Result {
    data class Success(val id: Long) : Result()
    data class Error(val messageResId: Int) : Result()
}

class AddTaskUseCaseImp constructor(private val repository: AddTaskRepository) : AddTaskUseCase {

    override suspend fun add(task: TaskDomainModel): Result {
        val add = repository.add(task)
        return if (add >= 0)
            Result.Success(add)
        else
            Result.Error(com.pignasoft.dotasks.R.string.unknown_error)
    }
}
