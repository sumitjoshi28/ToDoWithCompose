package com.sumit.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sumit.todoapp.ui.screens.ToDoHomeScreen
import com.sumit.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ToDoHomeScreen()
                }
            }
        }
    }
}