package com.pignasoft.dotasks.app.data.cache

import androidx.room.TypeConverter
import com.pignasoft.dotasks.app.data.cache.model.TaskType

class Converters {
    @TypeConverter
    fun converter(taskType: TaskType): String = taskType.name

    @TypeConverter
    fun converter(taskTypeName: String): TaskType = TaskType.valueOf(taskTypeName)

    @TypeConverter
    fun convert(str: String): List<String> =
        if (str.isNotBlank()) {
            str.removeSurrounding("[", "]").split(",").map { it.trim() }
        } else {
            emptyList()
        }

    @TypeConverter
    fun convert(list: List<String>): String = list.toString()
}
