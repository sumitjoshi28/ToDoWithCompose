package com.sumit.todoapp.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.sumit.todoapp.api.model.response.ToDoResponseItem
import com.sumit.todoapp.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class ToDoListViewModel(private val toDoRepository: ToDoRepository) : ViewModel() {
    private val _toDo: MutableStateFlow<List<ToDoResponseItem>> = MutableStateFlow(
        emptyList()
    )
    val toDo by lazy { _toDo.asStateFlow() }

    fun getToDosFromApi(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = toDoRepository.getToDosFromApi()
                    if (response.isSuccessful){
                        // Process state to update UI.
                        Log.d("response", "response: ${Gson().toJson(response.body())}")
                        val result = response.body()
                        _toDo.value = result?.toList() ?: emptyList()

                        // Save data to local db.
                        result?.forEach { toDoResponseItem ->
                            toDoRepository.saveToDo(toDoResponseItem = toDoResponseItem)
                        }
                    }else{
                        // In case of error show local data.
                        fetchDataFromDb()
                    }
                }catch (httpException:HttpException){
                    // In case of error show local data.
                    fetchDataFromDb()
                    Log.d("httpException", "getToDosFromApi: $httpException")
                }
            }
        }
    }
    fun fetchDataFromDb(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val list = toDoRepository.getToDoList()
                _toDo.value = list
            }
        }
    }

    fun hasNetworkAvailable(context: Context): Boolean? {
        val service = Context.CONNECTIVITY_SERVICE
        val connectivityManager = context.getSystemService(service) as ConnectivityManager?
        val connected = connectivityManager?.allNetworks?.any { network ->
            connectivityManager.getNetworkCapabilities(network)?.run {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                            hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                } else {
                    when (connectivityManager.activeNetworkInfo?.type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            } ?: false
        }
        return connected
    }
}