package com.test.testcleanarchitecture.di

import com.test.testcleanarchitecture.presentation.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(getUserNameUseCase = get(), saveUserNameUseCase = get())
    }

}