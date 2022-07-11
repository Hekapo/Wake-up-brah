package ru.itis.wakeupbrah.myalarmclock

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.annotation.RawRes
import androidx.annotation.RequiresApi
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.utils.Constants


class CustomNotificationChannel {
    private val audio by lazy {
        AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun createChannel(context: Context?) {
        if (context != null) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(
                Constants.CHANNEL_ID,
                context.getString(R.string.notification_channel_name),
                importance
            ).apply {
                description = context.getString(R.string.notification_channel_desc)

                val sound: Uri = context.getSoundUri(R.raw.mate1000)
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
