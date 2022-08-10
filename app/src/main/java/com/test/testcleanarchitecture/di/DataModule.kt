package com.test.testcleanarchitecture.di

import android.content.Context
import com.test.testcleanachitecture.data.repository.UserRepositoryImpl
import com.test.testcleanachitecture.data.storage.UserStorage
import com.test.testcleanachitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.test.testcleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}