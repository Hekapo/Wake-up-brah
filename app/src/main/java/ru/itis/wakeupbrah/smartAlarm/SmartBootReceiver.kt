package ru.itis.wakeupbrah.myalarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.itis.wakeupbrah.myReminder.SmartTimeRepository

class SmartBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            val smartTimeRepository = SmartTimeRepository
            val time = smartTimeRepository.getTime(context)
            if (time != -1L) {


            }
        }
    }
}