package com.test.testcleanarchitecture.domain.usecase

import com.test.testcleanarchitecture.domain.models.SaveUserNameParam
import com.test.testcleanarchitecture.domain.models.UserName
import com.test.testcleanarchitecture.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name was already saved`() {

        val testData = UserName(name = "TestName", surname = "TestSurname")
        Mockito.`when`(userRepository.getName()).thenReturn(testData)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserNameParam(name = "TestName")
        val actual = useCase.execute(param = testParams)
        val expected = true

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.never()).saveName(saveUserNameParam = any())
    }

    @Test
    fun `should return true if save was successful`() {

        val testData = UserName(name = "TestName", surname = "TestSurname")
        Mockito.`when`(userRepository.getName()).thenReturn(testData)
        val expected = true
        val testParams = SaveUserNameParam(name = "NewFirstName")
        Mockito.`when`(userRepository.saveName(testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val actual = useCase.execute(param = testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveUserNameParam = testParams)
    }

    @Test
    fun `should return false if save was successful`() {

        val testData = UserName(name = "TestName", surname = "TestSurname")
        Mockito.`when`(userRepository.getName()).thenReturn(testData)
        val expected = false
        val testParams = SaveUserNameParam(name = "NewFirstName")
        Mockito.`when`(userRepository.saveName(testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val actual = useCase.execute(param = testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveUserNameParam = testParams)
    }

}