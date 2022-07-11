package ru.itis.wakeupbrah.myReminder

import android.content.Context
import ru.itis.wakeupbrah.utils.Constants
import java.util.*

object ReminderRepository {
    fun saveReminder(calendar: String, context: Context) {
        val sharedPreferences = context.getSharedPreferences(Constants.TIME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("calendar", calendar)
            .apply()

    }

    fun getReminder(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(Constants.TIME, Context.MODE_PRIVATE)
        return sharedPreferences.getString("calendar", "").toString()
    }


}