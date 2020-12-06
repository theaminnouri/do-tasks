package com.pignasoft.feature_add.domain.usecase

import com.pignasoft.feature_add.R
import com.pignasoft.feature_add.domain.model.TaskDomainModel
import com.pignasoft.feature_add.domain.repository.AddTaskRepository

class AddTaskUseCase constructor(private val repository: AddTaskRepository) {
    sealed class Result {
        data class Success(val id: Long) : Result()
        data class Error(val messageResId: Int) : Result()
    }

    suspend fun add(task: TaskDomainModel): Result {
        val add = repository.add(task)
        return if (add >= 0)
            Result.Success(add)
        else
            Result.Error(R.string.unknown_error)
    }
}