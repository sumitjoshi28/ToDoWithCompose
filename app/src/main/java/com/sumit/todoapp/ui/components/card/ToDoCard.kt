package com.sumit.todoapp.ui.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumit.todoapp.api.model.response.ToDoResponseItem

@Composable
fun ToDoCard(todoResponseItem: ToDoResponseItem) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                var checked by remember { mutableStateOf(todoResponseItem.completed?:false) }
                Checkbox(
                    checked = checked, onCheckedChange = {
                        checked = it
                    }, modifier = Modifier.size(24.dp), colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.White,
                        checkmarkColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                if (todoResponseItem.completed == false){
                    Text(text = "Pending...", fontSize = 8.sp, color = Color.Blue)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = todoResponseItem.title?:"",
                        color = Color.White,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis)
                }
                Spacer(modifier = Modifier.weight(1f)) // Flexible spacer
            }
        }
    }
}
