package com.sumit.todoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sumit.todoapp.api.model.response.ToDoResponse
import com.sumit.todoapp.api.model.response.ToDoResponseItem
import com.sumit.todoapp.ui.components.card.ToDoCard
import com.sumit.todoapp.ui.theme.ToDoAppTheme
import com.sumit.todoapp.viewmodel.ToDoListViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val toDoListViewModel: ToDoListViewModel = koinViewModel<ToDoListViewModel>()
                    val todo = toDoListViewModel.toDo.collectAsState().value
                    // Getting the state from the view model and setting to UI.

                    val context = LocalContext.current
                    LaunchedEffect(Unit){
                        // As soon as this screen compose, call the API.
                        if (toDoListViewModel.hasNetworkAvailable(context) == true){
                            toDoListViewModel.getToDosFromApi()
                        }else{
                            toDoListViewModel.fetchDataFromDb()
                            Toast.makeText(context,"Please check internet connection",Toast.LENGTH_SHORT).show()
                        }

                    }
                    ToDoList(todo)
                }
            }
        }
    }
}

@Composable
fun ToDoList(todo: List<ToDoResponseItem>) {
    LazyColumn{
        items(todo){ todoResponseItem ->
            ToDoCard(todoResponseItem)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppTheme {
        ToDoList(todo = ToDoResponse())
    }
}