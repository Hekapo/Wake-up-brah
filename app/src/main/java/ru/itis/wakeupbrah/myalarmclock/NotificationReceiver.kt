package ru.itis.wakeupbrah.myalarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        val customNotification = CustomNotification()
        if (context != null) {
            customNotification.createNotification(context)
        }
    }
}
