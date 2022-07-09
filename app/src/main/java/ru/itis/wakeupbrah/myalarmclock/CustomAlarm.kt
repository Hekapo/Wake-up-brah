package com.example.myalarmclock

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import com.google.android.material.snackbar.Snackbar
import ru.itis.wakeupbrah.myalarmclock.AlarmReceiver
import ru.itis.wakeupbrah.myalarmclock.MyService
import java.util.*


class CustomAlarm (private var context: Context){

    @SuppressLint("UnspecifiedImmutableFlag")
    fun setAlarm(
        view: View,
        calendar: Calendar?,
        alarmManager: AlarmManager?,
    ): PendingIntent? {
        Snackbar.make(view, "Ваш будильник зазвенит в указанное время", 2000).show()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            calendar?.timeInMillis?.let {
                val i = Intent(context, AlarmReceiver::class.java).apply {
                    action = "com.tester.alarmManager"
                }
                val pendingIntent =
                    PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT)
                alarmManager?.setExact(AlarmManager.RTC_WAKEUP, it, pendingIntent)
                context.startForegroundService(Intent(context, MyService::class.java))
                return pendingIntent
            }
        }
        return null
    }


}
