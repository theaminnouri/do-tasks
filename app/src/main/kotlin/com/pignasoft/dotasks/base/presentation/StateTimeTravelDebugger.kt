package com.pignasoft.dotasks.base.presentation

import com.pignasoft.dotasks.base.presentation.state.BaseStateEvent
import com.pignasoft.dotasks.base.presentation.state.BaseViewState
import timber.log.Timber
import kotlin.reflect.full.memberProperties

class StateTimeTravelDebugger(private val viewModelClassName: String) {
    private var lastStateEvent: BaseStateEvent? = null
    private val stateTimeLine = mutableListOf<StateTransition>()

    fun addStateEvent(stateEvent: BaseStateEvent) {
        lastStateEvent = stateEvent
    }

    fun addStateTransition(oldViewState: BaseViewState, newViewState: BaseViewState) {
        val lastStateEvent =
            checkNotNull(lastStateEvent) { "lastStateEvent is null, Please log action before logging state transition" }
        stateTimeLine.add(
            StateTransition(
                oldViewState = oldViewState,
                stateEvent = lastStateEvent,
                newViewState = newViewState
            )
        )
    }

    fun logLast() {
        val states = listOf(stateTimeLine.last())
        Timber.d(getMessage(states))
    }

    private fun getMessage(states: List<StateTransition>): String {
        if (states.isEmpty())
            return "$viewModelClassName has no state transition \n"

        var message = ""

        stateTimeLine.forEach { stateTransition ->
            message += "StateEvent: $viewModelClassName.${stateTransition.stateEvent.javaClass.simpleName}"

            propertyName.forEach { propertyName ->
                val logLine = getLogLine(
                    stateTransition.oldViewState,
                    stateTransition.newViewState,
                    propertyName
                )
                message += logLine
            }
        }
        return message
    }

    private fun getLogLine(
        oldViewState: BaseViewState,
        newViewState: BaseViewState,
        propertyName: String
    ): String {
        val oldPropertyValue = getPropertyValue(oldViewState, propertyName)
        val newPropertyValue = getPropertyValue(newViewState, propertyName)
        val indent = "\n"

        return if (oldPropertyValue != newPropertyValue)
            "$indent*$propertyName: $oldPropertyValue -> $newPropertyValue $indent"
        else
            "$indent*$propertyName: $newPropertyValue $indent"
    }

    private fun getPropertyValue(baseViewState: BaseViewState, propertyName: String): String {
        baseViewState.javaClass.kotlin.memberProperties.forEach {
            if (it.name == propertyName) {
                var value = it.getter.call(baseViewState).toString()
                if (value.isBlank())
                    value = "\"\""
                return value
            }
        }
        return ""
    }

    private val propertyName by lazy {
        stateTimeLine.first().oldViewState.javaClass.kotlin.memberProperties.map { it.name }
    }

    private data class StateTransition(
        val oldViewState: BaseViewState,
        val stateEvent: BaseStateEvent,
        val newViewState: BaseViewState
    )
}
