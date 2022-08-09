package com.test.testcleanarchitecture.di

import com.test.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.test.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

}