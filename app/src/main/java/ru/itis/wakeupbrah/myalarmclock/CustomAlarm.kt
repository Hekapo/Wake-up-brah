package ru.itis.wakeupbrah.myalarmclock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import ru.itis.wakeupbrah.features.main.MainActivity


class CustomAlarm {

//    @SuppressLint("UnspecifiedImmutableFlag")
//    fun setAlarm(
//        view: View,
//        calendar: Calendar?,
//        alarmManager: AlarmManager?,
//    ): PendingIntent? {
//        Snackbar.make(view, "Ваш будильник зазвенит в указанное время", 2000).show()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//
//            calendar?.timeInMillis?.let {
//                val i = Intent(context, AlarmReceiver::class.java).apply {
//                    action = "com.tester.alarmManager"
//                }
//                val pendingIntent =
//                    PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT)
//                alarmManager?.setExact(AlarmManager.RTC_WAKEUP, it, pendingIntent)
//                context.startForegroundService(Intent(context, MyService::class.java))
//                return pendingIntent
//            }
//        }
//        return null
//    }


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
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    private fun getAlarmActionPendingIntent(context: Context): PendingIntent? {
        val intent = Intent(context, NotificationReceiver::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        return PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }


}
