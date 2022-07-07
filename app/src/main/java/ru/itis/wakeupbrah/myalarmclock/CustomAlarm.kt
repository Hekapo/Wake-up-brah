package com.example.myalarmclock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import ru.itis.wakeupbrah.myalarmclock.MainActivity
import java.util.*


class CustomAlarm {

    fun setAlarm(context: Context, time: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val info = AlarmManager.AlarmClockInfo(time, getAlarmInfoPendingIntent(context))

        alarmManager.setAlarmClock(info, getAlarmActionPendingIntent(context))

    }

    fun cancelAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(getAlarmActionPendingIntent(context))
    }



    private fun getAlarmInfoPendingIntent(context: Context): PendingIntent? {
        val alarmInfoIntent = Intent(context, MainActivity::class.java)
        alarmInfoIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        return PendingIntent.getActivity(
            context,
            0,
            alarmInfoIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
    }


    private fun getAlarmActionPendingIntent(context: Context): PendingIntent? {
        val intent = Intent(context, AlarmActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
          return PendingIntent.getActivity(
              context,
              1,
              intent,
              PendingIntent.FLAG_IMMUTABLE)
    }


}
