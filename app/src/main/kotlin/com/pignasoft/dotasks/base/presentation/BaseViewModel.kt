package com.pignasoft.dotasks.base.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pignasoft.dotasks.BuildConfig
import com.pignasoft.dotasks.feature.base.presentation.state.BaseStateEvent
import com.pignasoft.dotasks.base.presentation.state.BaseViewState
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

abstract class BaseViewModel<ViewState : BaseViewState, StateEvent : BaseStateEvent>(initialState: ViewState) :
    ViewModel() {
    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState
    private var stateTimeTravelDebugger: StateTimeTravelDebugger? = null

    init {
        if (BuildConfig.DEBUG) {
            stateTimeTravelDebugger = StateTimeTravelDebugger(this::class.java.simpleName)
        }
    }

    protected var state: ViewState by Delegates.observable(initialState) { _, old, new ->
        _viewState.value = new

        if (old != new)
            stateTimeTravelDebugger?.apply {
                addStateTransition(old, new)
                logLast()
            }
    }

    fun sendStateEvent(stateEvent: StateEvent) {
        stateTimeTravelDebugger?.addStateEvent(stateEvent)
        viewModelScope.launch {
            state = onReduceStateEvent(stateEvent)
        }
    }

    protected abstract suspend fun onReduceStateEvent(stateEvent: StateEvent): ViewState
}