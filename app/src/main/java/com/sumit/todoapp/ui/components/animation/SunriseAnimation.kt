package com.sumit.todoapp.ui.components.animation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sumit.todoapp.R

@Composable
fun SunriseAnimation(modifier: Modifier){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.sun_animation))
    LottieAnimation(
        iterations = LottieConstants.IterateForever,
        composition = composition,
        modifier = modifier
    )
}