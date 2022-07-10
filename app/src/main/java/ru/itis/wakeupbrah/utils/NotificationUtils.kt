package ru.itis.wakeupbrah.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import ru.itis.wakeupbrah.R

class NotificationUtils(private val context: Context) {

    private val notificationManager by lazy {
        context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(
        idString: String,
        name: String,
        importance: Int,
    ) {
        val channel = NotificationChannel(idString, name, importance).apply {
            lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            vibrationPattern = longArrayOf(0, 1000)
            setSound(
                Uri.parse("android.resource://${context.packageName}/${R.raw.ara_ara}"),
                AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ALARM).build()
            )
        }

        notificationManager.createNotificationChannel(channel)
    }

    fun buildNotification(
        channelId: String,
        title: String,
        content: String,
        onClickIntent: PendingIntent?
    ) {
        NotificationCompat
            .Builder(context, channelId)
            .setSmallIcon(R.drawable.alarm_add)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setContentIntent(onClickIntent)
            .build()
    }

    fun cancelNotification(id: Int) {
        notificationManager.cancel(id)
    }

    fun fireNotification(id: Int, notification: Notification) =
        NotificationManagerCompat.from(context).notify(id, notification)

}
