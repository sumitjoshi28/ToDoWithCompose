package com.sumit.todoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.sumit.todoapp.ui.components.animation.MoonAnimation
import com.sumit.todoapp.ui.components.animation.SunriseAnimation
import com.sumit.todoapp.ui.components.textview.DescriptionText
import com.sumit.todoapp.ui.components.textview.HeaderText
import com.sumit.todoapp.util.Helper

@Composable
fun ToDoHomeScreen(padding: PaddingValues){
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            if (Helper.isItTheNight()){
                MoonAnimation(modifier = Modifier
                    .size(30.dp)
                    .wrapContentSize()
                    .scale(2f, 2f))
            }else{
                SunriseAnimation(modifier = Modifier
                    .size(30.dp)
                    .wrapContentSize()
                    .scale(2f, 2f))
            }
            Spacer(modifier = Modifier.width(24.dp))
            HeaderText(text = "${Helper.getMorningEveningOrAfternoon()}, Sumit")
        }
        Spacer(modifier = Modifier.height(24.dp))
        DescriptionText(text = "Today, ${Helper.getTodayDate()}")
    }
}