package ru.itis.wakeupbrah.myalarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class ReminderNotificationReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, p1: Intent?) {
        val customNotification = ReminderCustomNotification()
        if (context != null) {
            customNotification.createNotification(context)
        }
    }
}
