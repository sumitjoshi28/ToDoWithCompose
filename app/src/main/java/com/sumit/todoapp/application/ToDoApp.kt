package com.sumit.todoapp.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.sumit.todoapp.di.koin.koinMainModule
import com.sumit.todoapp.di.koin.koinRetrofitModule
import com.sumit.todoapp.di.koin.koinViewModelModule

class ToDoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }
    private fun setupKoin() {
        val koinModules = listOf(
            koinMainModule,
            koinViewModelModule,
            koinRetrofitModule,
        )

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@ToDoApp)
            // Load modules
            modules(koinModules)
        }
    }
}