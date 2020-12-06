package com.pignasoft.feature_add.domain.model

data class TaskDomainModel(
    val id: Long,
    val title: String,
    val description: String,
    val remindAt: String = "",
    val type: TaskTypeDomainModel = TaskTypeDomainModel.Doable(),
    val days: List<String> = listOf()
)