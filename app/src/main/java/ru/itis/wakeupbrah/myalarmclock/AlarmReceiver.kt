package com.example.myalarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.myalarmclock.CustomAlarm
import com.example.myalarmclock.TimeRepository

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            val timeRepository = TimeRepository()
            val alarm = CustomAlarm()
            alarm.setAlarm(context, timeRepository.getTime(context))

        }
    }

}
