package com.test.testcleanachitecture.data.repository

import android.util.Log
import com.test.testcleanachitecture.data.storage.models.User
import com.test.testcleanachitecture.data.storage.UserStorage
import com.test.testcleanarchitecture.domain.models.SaveUserNameParam
import com.test.testcleanarchitecture.domain.models.UserName
import com.test.testcleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveUserNameParam: SaveUserNameParam) : Boolean {
        val user = User(firstName = saveUserNameParam.name, lastName = "")
        return userStorage.saveName(user)
    }

    override fun getName(): UserName {
        val user = userStorage.getName()
        Log.d("MyLog", user.toString())
        return UserName(name = user.firstName, surname = user.lastName)
    }

}