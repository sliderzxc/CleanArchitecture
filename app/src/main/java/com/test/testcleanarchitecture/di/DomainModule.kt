package com.test.testcleanarchitecture.di

import com.test.testcleanarchitecture.domain.repository.UserRepository
import com.test.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.test.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }

}