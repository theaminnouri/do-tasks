package com.pignasoft.feature.tasks.presentation.state

import com.pignasoft.dotasks.base.presentation.state.BaseViewState

data class AddTaskViewState(
    val loading: Boolean = true,
    val isAdded: Boolean = false,
    val errorMessageResId: Int? = null
) : BaseViewState
