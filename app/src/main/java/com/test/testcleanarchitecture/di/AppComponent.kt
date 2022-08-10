package com.test.testcleanarchitecture.di

import com.test.testcleanarchitecture.presentation.ui.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}