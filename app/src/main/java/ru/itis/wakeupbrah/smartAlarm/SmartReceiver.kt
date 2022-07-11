package ru.itis.wakeupbrah.myalarmclock

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.itis.wakeupbrah.myReminder.SmartTimeRepository
import ru.itis.wakeupbrah.smartAlarm.CustomSmart

class SmartReceiver : BroadcastReceiver() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onReceive(context: Context, intent: Intent) {
        val smartTimeRepository = SmartTimeRepository
        val alarm = CustomSmart()
        alarm.setAlarm(context, smartTimeRepository.getTime(context))
    }
}