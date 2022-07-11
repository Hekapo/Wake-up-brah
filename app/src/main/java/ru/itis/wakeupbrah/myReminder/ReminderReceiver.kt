package ru.itis.wakeupbrah.myalarmclock

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.itis.wakeupbrah.myReminder.ReminderTimeRepository

class ReminderReceiver : BroadcastReceiver() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onReceive(context: Context, intent: Intent) {
        val reminderTimeRepository = ReminderTimeRepository
        val alarm = CustomReminder()
        alarm.setAlarm(context, reminderTimeRepository.getTime(context))

    }
}