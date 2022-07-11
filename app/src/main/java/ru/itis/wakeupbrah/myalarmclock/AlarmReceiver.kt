package ru.itis.wakeupbrah.myalarmclock

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onReceive(context: Context, intent: Intent) {
        val timeRepository = TimeRepository
        val alarm = CustomAlarm()
        alarm.setAlarm(context, timeRepository.getTime(context))

    }
}