package com.test.testcleanarchitecture.di

import com.test.testcleanachitecture.data.repository.UserRepositoryImpl
import com.test.testcleanachitecture.data.storage.UserStorage
import com.test.testcleanachitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.test.testcleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}