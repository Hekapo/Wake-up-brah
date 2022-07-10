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

//        intent?.let {
//            if (it.action == "com.tester.alarmManager") {
//                val i = Intent(context, AlarmActivity::class.java)
//                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                val pendingIntent =
//                    PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT)
//                val notification = context?.let { cont ->
//                    NotificationCompat.Builder(cont, "ALARM")
//                        .setSmallIcon(R.drawable.alarm_add)
//                        .setContentTitle("Прозвенел будильник!")
//                        .setContentText("Самая пора выключить его")
//                        .setAutoCancel(true)
//                        .setPriority(NotificationCompat.PRIORITY_HIGH)
//                        .setContentIntent(pendingIntent)
//                        .setSound(Uri.parse("android.resource://" + context.packageName + "/" + R.raw.ara_ara))
//                        .setVibrate(longArrayOf(100L, 200L, 0L, 300L))
//                        .setColor(Color.CYAN)
//                }
//                if (context != null) {
//                    notification?.build()?.let { notif ->
//                        NotificationManagerCompat.from(context).notify(1, notif)
//                        context.stopService(Intent(context, MyService::class.java))
//                    }
//                }
//            }
//        }
    }
}