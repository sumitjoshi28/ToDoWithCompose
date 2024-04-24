package com.sumit.todoapp.di.koin

import com.sumit.todoapp.repository.ToDoRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val koinMainModule = module {

    /*single {
        ChargerDatabase.setupChargerDatabase(androidContext())
    } bind ChargerDatabase::class*/

    singleOf(::ToDoRepository)
}