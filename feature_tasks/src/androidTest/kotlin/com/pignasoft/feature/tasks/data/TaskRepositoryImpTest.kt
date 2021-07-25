package com.pignasoft.feature.tasks.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pignasoft.dotasks.app.data.cache.AppDatabase
import com.pignasoft.dotasks.app.data.cache.dao.TaskDao
import com.pignasoft.feature.tasks.domain.model.Task
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class TaskRepositoryImpTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: AppDatabase
    private lateinit var taskDao: TaskDao
    private lateinit var cut: TaskRepositoryImp


    @Before
    fun before() {
        val context = InstrumentationRegistry.getInstrumentation().context

        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()

        taskDao = database.getTaskDao()
        cut = TaskRepositoryImp(taskDao)
    }

    @After
    fun after() {
        database.close()
    }


    @Test
    fun getListReturnEmpty() {
        var taskList: List<Task>
        runBlocking { taskList = cut.getTaskList() }

        taskList.isEmpty() shouldBeEqualTo true
    }
}
