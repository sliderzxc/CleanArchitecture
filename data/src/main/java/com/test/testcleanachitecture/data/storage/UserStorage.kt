package com.test.testcleanachitecture.data.storage

import com.test.testcleanachitecture.data.storage.models.User

interface UserStorage {

    fun saveName(user: User) : Boolean

    fun getName() : User
}