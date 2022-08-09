package com.test.testcleanarchitecture.domain.usecase

import com.test.testcleanarchitecture.domain.models.UserName
import com.test.testcleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute() : UserName {
        return userRepository.getName()
    }
}