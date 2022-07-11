package ru.itis.wakeupbrah.myalarmclock

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import ru.itis.wakeupbrah.MainFragment2
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.features.open_alarm.AlarmActivity
import ru.itis.wakeupbrah.features.set_alarm.MainFragment
import ru.itis.wakeupbrah.myReminder.ReminderRepository
import ru.itis.wakeupbrah.smartAlarm.SmartActivity
import ru.itis.wakeupbrah.time_patterns.TimePatternsFragment
import ru.itis.wakeupbrah.utils.Constants


class SmartCustomNotification {

    @RequiresApi(Build.VERSION_CODES.M)
    fun createNotification(context: Context) {
        val intent = Intent(context, SmartActivity::class.java).let {
            PendingIntent.getActivities(
                context,
                123,
                arrayOf(it),
                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE

            )

        }

        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID)
            .setSmallIcon(R.drawable.img)
            .setContentTitle("Проснись, друг!!!")
            .setShowWhen(false)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle().bigText(
                    "!!!Проснись!!!"
                )
            )
            .setContentIntent(intent)
            .setContentText("Проснись")

        val notificationManager = context.getSystemService(NotificationManager::class.java)

        notificationManager.notify(1, builder.build())

    }
}