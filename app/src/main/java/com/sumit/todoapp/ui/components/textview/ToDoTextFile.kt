package com.sumit.todoapp.ui.components.textview

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sumit.todoapp.R

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current.
    copy(
        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
        fontFamily = FontFamily(
            Font(R.font.robotobold)
        ),
        fontSize = 24.sp,
        textAlign = TextAlign.Start
    )
) {
    Text(
        text = text,
        modifier = modifier,
        style = style)
}

@Composable
fun DescriptionText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current.
    copy(
        color = if (isSystemInDarkTheme()) Color.White.copy(0.4f) else Color.Black.copy(0.4f),
        fontFamily = FontFamily(
            Font(R.font.robotoregular)
        ),
        fontSize = 16.sp,
        textAlign = TextAlign.Start
    )
) {
    Text(
        text = text,
        modifier = modifier,
        style = style)
}
