package com.pignasoft.feature.addTask.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.pignasoft.feature.addTask.domain.model.TaskDomainModel
import com.pignasoft.feature.addTask.domain.usecase.AddTaskUseCase
import com.pignasoft.feature.addTask.domain.usecase.Result
import com.pignasoft.feature.addTask.presentation.state.AddTaskStateEvent
import com.pignasoft.feature.addTask.presentation.state.AddTaskViewState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AddTaskViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var addTaskUseCase: AddTaskUseCase

    private lateinit var cut: AddTaskViewModel
    private val task = TaskDomainModel(
        id = 1,
        title = "title_1",
        description = "desc_1",
    )
    private val viewStateObserver = spyk<Observer<AddTaskViewState>>()

    @Before
    fun before() {
        MockKAnnotations.init(this)
        cut = AddTaskViewModel(addTaskUseCase)

        cut.viewState.observeForever(viewStateObserver)
    }

    @Test
    fun whenTryToAddTask_enableLoading() {
        cut.sendStateEvent(AddTaskStateEvent.AddTaskEvent(task))

        val list = mutableListOf<AddTaskViewState>()
        verify { viewStateObserver.onChanged(capture(list)) }
        list.first().loading shouldBeEqualTo true
    }

    @Test
    fun whenProcessFinished_disableLoading() {
        coEvery { addTaskUseCase.add(any()) } answers { Result.Success(task.id) }

        cut.sendStateEvent(AddTaskStateEvent.AddTaskEvent(task))

        val list = mutableListOf<AddTaskViewState>()
        verify { viewStateObserver.onChanged(capture(list)) }
        list.last().loading shouldBeEqualTo false
    }

    @Test
    fun whenAddTaskSuccessful_taskIsAddedEqualTrue() {
        coEvery { addTaskUseCase.add(any()) } answers { Result.Success(task.id) }

        cut.sendStateEvent(AddTaskStateEvent.AddTaskEvent(task))

        val list = mutableListOf<AddTaskViewState>()
        verify { viewStateObserver.onChanged(capture(list)) }
        list.last().isAdded shouldBeEqualTo true
    }
}