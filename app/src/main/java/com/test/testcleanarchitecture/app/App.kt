package com.test.testcleanarchitecture.app

import android.app.Application
import com.test.testcleanarchitecture.di.AppComponent
import com.test.testcleanarchitecture.di.AppModule
import com.test.testcleanarchitecture.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}