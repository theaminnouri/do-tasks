package com.pignasoft.feature_add.domain.model

data class TaskDomainModel(
    val id: Long,
    val title: String,
    val description: String,
    val completed: Boolean? = null,
    val remindAt: String = "",
    val type: TaskTypeDomainModel = TaskTypeDomainModel.Doable,
    val days: List<String> = listOf(),
    val duration: Long = 0,
    val expectedDuration: Long = 0,
    val createDate: Long = 0,
    val updateDate: Long = 0
)
