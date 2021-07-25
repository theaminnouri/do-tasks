package com.pignasoft.feature.tasks.presentation

import com.pignasoft.dotasks.base.presentation.BaseViewModel
import com.pignasoft.feature.tasks.domain.usecase.AddTaskUseCase
import com.pignasoft.feature.tasks.domain.usecase.Result.Error
import com.pignasoft.feature.tasks.domain.usecase.Result.Success
import com.pignasoft.feature.tasks.presentation.state.AddTaskStateEvent
import com.pignasoft.feature.tasks.presentation.state.AddTaskViewState

class AddTaskViewModel(private val addTaskUseCaseImp: AddTaskUseCase) :
    BaseViewModel<AddTaskViewState, AddTaskStateEvent>(AddTaskViewState()) {

    override suspend fun onReduceStateEvent(stateEvent: AddTaskStateEvent): AddTaskViewState {
        return when (stateEvent) {
            is AddTaskStateEvent.AddTaskEvent -> {
                val newViewState = when (val add = addTaskUseCaseImp.add(stateEvent.task)) {
                    is Success -> state.copy(
                        loading = false,
                        isAdded = true
                    )
                    is Error -> state.copy(
                        loading = false,
                        isAdded = false,
                        errorMessageResId = add.messageResId
                    )
                }
                newViewState
            }
        }
    }
}
