package com.pignasoft.feature.tasks.domain.model

import com.pignasoft.dotasks.app.data.cache.model.TaskEntity

fun TaskEntity.toTask(): Task {
    return Task(
        id = id,
        title = title,
        description = description,
        remind_at = remind_at,
        completed = completed,
        type = type,
        expected_duration = expected_duration,
        duration = duration,
        days = days,
        create_date = create_date,
        update_date = update_date
    )
}