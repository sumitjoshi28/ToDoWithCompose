package com.sumit.todoapp.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Helper {
    fun getMorningEveningOrAfternoon():String{
        val hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hourOfDay) {
            in 4..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            in 17..23 -> "Good Evening"
            else -> "It's Midnight"
        }
    }

    fun isItTheNight():Boolean{
        val hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hourOfDay) {
            in 4..11 -> false
            in 12..16 -> false
            in 17..19 -> false
            in 20..23 -> true
            else -> true
        }
    }

    fun getTodayDate(): String {
        val dateFormat = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
        val currentDate = Calendar.getInstance().time
        val dayOfMonth = SimpleDateFormat("d", Locale.getDefault()).format(currentDate).toInt()
        val formattedDay = when (dayOfMonth) {
            1, 21, 31 -> "${dayOfMonth}st"
            2, 22 -> "${dayOfMonth}nd"
            3, 23 -> "${dayOfMonth}rd"
            else -> "${dayOfMonth}th"
        }
        return "${formattedDay}${dateFormat.format(currentDate).substring(2)}" // Removing the space before the month
    }
}