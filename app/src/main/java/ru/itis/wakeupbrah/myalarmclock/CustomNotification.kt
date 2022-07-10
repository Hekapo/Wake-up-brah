package ru.itis.wakeupbrah.myalarmclock

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.features.open_alarm.AlarmActivity
import ru.itis.wakeupbrah.utils.Constants


class CustomNotification {

    @RequiresApi(Build.VERSION_CODES.M)
    fun createNotification(context: Context) {
        val intent = Intent(context, AlarmActivity::class.java).let {
            PendingIntent.getActivities(
                context,
                123,
                arrayOf(it),
                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE

            )

        }

        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID)
            .setSmallIcon(R.drawable.leather)
            .setContentTitle("Leather man")
            .setShowWhen(false)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle().bigText(
                    "!!!Проснись!!!"
                )
            )
            .setContentIntent(intent)
            .setContentText("Desc")

        val notificationManager = context.getSystemService(NotificationManager::class.java)

        notificationManager.notify(1, builder.build())

    }
}