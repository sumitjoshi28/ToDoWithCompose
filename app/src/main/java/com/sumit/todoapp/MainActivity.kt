package com.sumit.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sumit.todoapp.ui.components.textview.ButtonText
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
                    Scaffold(content = {
                        ToDoHomeScreen(it)
                    }, floatingActionButton = {
                        ExtendedFloatingActionButton(
                            onClick = {
                                // TODO, Add a click action here.
                            },
                            icon = { Icon(Icons.Default.AddCircle, "Extended floating action button.") },
                            text = { ButtonText(text = "Add a note") },
                        )
                    })
                }
            }
        }
    }
}