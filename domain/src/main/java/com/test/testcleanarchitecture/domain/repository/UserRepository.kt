package com.test.testcleanarchitecture.domain.repository

import com.test.testcleanarchitecture.domain.models.SaveUserNameParam
import com.test.testcleanarchitecture.domain.models.UserName

interface UserRepository {

    fun saveName(saveUserNameParam: SaveUserNameParam) : Boolean

    fun getName() : UserName
}