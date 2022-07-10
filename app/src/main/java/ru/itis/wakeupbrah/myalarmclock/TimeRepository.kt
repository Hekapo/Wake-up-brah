package ru.itis.wakeupbrah.myalarmclock

import android.content.Context
import ru.itis.wakeupbrah.utils.Constants
import java.text.SimpleDateFormat
import java.util.*

object TimeRepository {

    fun saveTime(calendar: Calendar, context: Context) {
        val sharedPreferences = context.getSharedPreferences(Constants.TIME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putLong(Constants.TIME_IN_MILLISECONDS, calendar.timeInMillis)
            .apply()

    }

    fun getTime(context: Context): Long {
        val sharedPreferences = context.getSharedPreferences(Constants.TIME, Context.MODE_PRIVATE)
        return sharedPreferences.getLong(Constants.TIME_IN_MILLISECONDS, -1L)
    }

//    fun getCurrentTime(): Long {

//    }
}