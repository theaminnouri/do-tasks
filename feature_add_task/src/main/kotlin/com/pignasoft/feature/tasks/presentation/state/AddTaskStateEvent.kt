package com.pignasoft.feature.tasks.presentation.state

import com.pignasoft.dotasks.base.presentation.state.BaseStateEvent
import com.pignasoft.feature.tasks.domain.model.TaskDomainModel

sealed class AddTaskStateEvent : BaseStateEvent {

    data class AddTaskEvent(val task: TaskDomainModel) : AddTaskStateEvent()
}
