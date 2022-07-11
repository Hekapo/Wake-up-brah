package ru.itis.wakeupbrah.myalarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.itis.wakeupbrah.myReminder.ReminderTimeRepository

class ReminderBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            val reminderTimeRepository = ReminderTimeRepository
            val time = reminderTimeRepository.getTime(context)
            if (time != -1L) {


            }
        }
    }
}