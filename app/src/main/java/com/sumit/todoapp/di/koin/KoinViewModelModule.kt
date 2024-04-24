package com.sumit.todoapp.di.koin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.sumit.todoapp.viewmodel.ToDoListViewModel


val koinViewModelModule = module {
    viewModelOf(::ToDoListViewModel)
}