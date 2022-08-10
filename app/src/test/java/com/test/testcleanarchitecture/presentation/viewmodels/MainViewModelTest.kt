package com.test.testcleanarchitecture.presentation.viewmodels

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.testcleanarchitecture.domain.models.SaveUserNameParam
import com.test.testcleanarchitecture.domain.models.UserName
import com.test.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.test.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

class MainViewModelTest() {

    private val getUserNameUseCase = mock<GetUserNameUseCase>()
    private val saveUserNameUseCase = mock<SaveUserNameUseCase>()

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserNameUseCase)
        Mockito.reset(saveUserNameUseCase)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @BeforeEach
    fun beforeEach() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

        })
    }

    @Test
    fun `should save username and return true`() {
        val saveResult = true
        val testSaveText = "Test user name"
        val testParams = SaveUserNameParam(name = testSaveText)

        Mockito.`when`(saveUserNameUseCase.execute(param = testParams)).thenReturn(saveResult)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

        viewModel.saveData(textUser = testSaveText)

        val actual = viewModel.result.value
        val expected = "Save result = true"

        Mockito.verify(saveUserNameUseCase, times(1)).execute(param = testParams)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should save username and return false`() {
        val saveResult = false
        val testSaveText = "Test user name"
        val testParams = SaveUserNameParam(name = testSaveText)

        Mockito.`when`(saveUserNameUseCase.execute(param = testParams)).thenReturn(saveResult)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

        viewModel.saveData(textUser = testSaveText)

        val actual = viewModel.result.value
        val expected = "Save result = false"

        Mockito.verify(saveUserNameUseCase, times(1)).execute(param = testParams)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should load username`() {

        val testUserName = UserName(
            name = "Test first name",
            surname = "Test surname"
        )

        Mockito.`when`(getUserNameUseCase.execute()).thenReturn(testUserName)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

        viewModel.getData()

        val expected = "${testUserName.name} ${testUserName.surname}"
        val actual = viewModel.result.value

        Assertions.assertEquals(expected, actual)
    }

}