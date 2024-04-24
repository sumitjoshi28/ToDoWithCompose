package com.sumit.todoapp.di.koin

import com.sumit.todoapp.db.LocalDb
import com.sumit.todoapp.repository.ToDoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinMainModule = module {
    // Setting up db and repository here.
    single {
        LocalDb.setupChargerDatabase(androidContext())
    } bind LocalDb::class

    singleOf(::ToDoRepository)
}