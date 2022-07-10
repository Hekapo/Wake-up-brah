package ru.itis.wakeupbrah.myalarmclock

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.net.Uri
import androidx.annotation.RawRes
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.utils.Constants


class CustomNotificationChannel {
    private val audio by lazy {
        AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()
    }

    fun createChannel(context: Context?) {
        if (context != null) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(
                Constants.CHANNEL_ID,
                context.getString(R.string.notification_channel_name),
                importance
            ).apply {
                description = context.getString(R.string.notification_channel_desc)
                val sound: Uri = context.getSoundUri(R.raw.ara_ara)
                setSound(sound, audio)
            }

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun Context.getSoundUri(
        @RawRes id: Int
    ) = Uri.parse("android.resource://${packageName}/$id")
}
