package com.pignasoft.feature.tasks.domain.usecase

import com.pignasoft.dotasks.feature.addTask.R
import com.pignasoft.feature.tasks.domain.model.TaskDomainModel
import com.pignasoft.feature.tasks.domain.repository.AddTaskRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AddTaskUseCaseImpTest {
    @MockK
    internal lateinit var repository: AddTaskRepository
    private lateinit var cut: AddTaskUseCaseImp
    private val task = TaskDomainModel(id = 1L, title = "title", description = "description")

    @Before
    fun before() {
        MockKAnnotations.init(this)
        cut = AddTaskUseCaseImp(repository)
    }

    @Test
    fun whenAddTask_returnSuccessResult() {

        coEvery { repository.add(any()) } returns 1L

        val result = runBlocking {
            cut.add(task)
        }

        result shouldBeEqualTo Result.Success(1L)
    }

    @Test
    fun whenTaskNotAdded_returnFailureResult() {

        coEvery { repository.add(any()) } returns -1L

        val result = runBlocking { cut.add(task) }

        result shouldBeEqualTo Result.Error(R.string.unknown_error)
    }
}
