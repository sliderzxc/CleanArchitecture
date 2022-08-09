package com.test.testcleanarchitecture.domain.usecase

import com.test.testcleanarchitecture.domain.models.UserName
import com.test.testcleanarchitecture.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

//class TestUserRepository : UserRepository {
//    override fun saveName(saveUserNameParam: SaveUserNameParam): Boolean {
//        return true
//    }
//
//    override fun getName(): UserName {
//        return UserName(name = "TestName", surname = "TestSurname")
//    }
//}

class GetUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {

        val testData = UserName(name = "TestName", surname = "TestSurname")
        Mockito.`when`(userRepository.getName()).thenReturn(testData)
        //val testRepository = TestUserRepository()
        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(name = "TestName", surname = "TestSurname")

        Assertions.assertEquals(expected, actual)
    }

}