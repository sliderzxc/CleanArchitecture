package com.test.testcleanarchitecture.domain.usecase

import com.test.testcleanarchitecture.domain.models.SaveUserNameParam
import com.test.testcleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam) : Boolean {
        // bad practice
        val oldUserName = userRepository.getName()
        if (oldUserName.name == param.name) return true
        // end bad practice
        return userRepository.saveName(param)
    }
}