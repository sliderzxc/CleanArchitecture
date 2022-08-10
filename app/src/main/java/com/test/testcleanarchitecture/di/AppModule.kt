package com.test.testcleanarchitecture.di

import android.content.Context
import com.test.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.test.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import com.test.testcleanarchitecture.presentation.viewmodels.MainViewModuleFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ) : MainViewModuleFactory {
        return MainViewModuleFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }

    @Provides
    fun provideContext() : Context {
        return context
    }

}