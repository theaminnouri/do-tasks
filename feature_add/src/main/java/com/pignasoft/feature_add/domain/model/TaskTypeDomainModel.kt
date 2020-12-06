package com.pignasoft.feature_add.domain.model

sealed class TaskTypeDomainModel {
    data class Doable(
        val completed: Boolean? = null
    ) : TaskTypeDomainModel()

    data class Timer(
        val duration: Long,
        val completed: Boolean? = null
    ) : TaskTypeDomainModel()

    data class StopWatch(
        val duration: Long,
        val completed: Boolean? = null
    ) : TaskTypeDomainModel()
}
