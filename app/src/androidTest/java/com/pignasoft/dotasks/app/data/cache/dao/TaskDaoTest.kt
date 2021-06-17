package com.pignasoft.dotasks.app.data.cache.dao

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pignasoft.dotasks.app.data.cache.AppDatabase
import com.pignasoft.dotasks.app.data.cache.model.TaskEntity
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaskDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var taskDao: TaskDao

    private val task1 =
        TaskEntity(
            id = 1L,
            title = "title_1",
            description = "description_1",
            days = listOf("fri")
        )
    private val task2 = TaskEntity(
        id = 2L,
        title = "title_2",
        description = "description_2",
        days = listOf("fri", "sat")
    )
    private val task3 =
        TaskEntity(
            id = 3L,
            title = "title_3",
            description = "description_3",
            days = listOf("")
        )

    @Before
    fun before() {
        val context = InstrumentationRegistry.getInstrumentation().context

        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()

        taskDao = database.getTaskDao()
    }

    @Test
    fun whenAddAndRetrieveTasks_returnValidTask() {
        val list = listOf(task1, task2, task3)
        runBlocking { taskDao.add(list) }

        val result = runBlocking { taskDao.getTasks() }

        result shouldBeEqualTo list
    }
}
