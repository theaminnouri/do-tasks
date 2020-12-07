package com.pignasoft.feature_add.domain.model

sealed class TaskTypeDomainModel {
    object Doable : TaskTypeDomainModel()

    data class Timer(
        val duration: Long,
    ) : TaskTypeDomainModel()

    data class StopWatch(
        val duration: Long,
    ) : TaskTypeDomainModel()
}
