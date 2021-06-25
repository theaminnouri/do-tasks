package com.pignasoft.feature.addTask.presentation.state

import com.pignasoft.dotasks.base.presentation.state.BaseStateEvent
import com.pignasoft.feature.addTask.domain.model.TaskDomainModel

sealed class AddTaskStateEvent : BaseStateEvent {

    data class AddTaskEvent(val task: TaskDomainModel) : AddTaskStateEvent()
}
