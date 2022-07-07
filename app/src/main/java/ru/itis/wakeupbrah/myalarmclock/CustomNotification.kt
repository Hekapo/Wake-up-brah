package com.example.myalarmclock

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.myalarmclock.Constants
import ru.itis.wakeupbrah.R

class CustomNotification {


    @RequiresApi(Build.VERSION_CODES.M)
    fun createNotification(context: Context) {
        val intent = Intent(context, AlarmActivity::class.java).let {
            PendingIntent.getActivities(
                context,
                123,
                arrayOf(it),
                PendingIntent.FLAG_ONE_SHOT
            )
        }

        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID)
            .setSmallIcon(R.drawable.leather)
            .setContentTitle("Leather man")
            .setShowWhen(false)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle().bigText(
                    "TRY HARD WORK HARD"
                )
            )
            .setContentIntent(intent)
            .setContentText("Desc")
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, builder.build())
    }
}
