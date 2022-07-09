package ru.itis.wakeupbrah.myalarmclock

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import ru.itis.wakeupbrah.R

class MyService : Service() {

    override fun onCreate() {
        startForeground(2, NotificationCompat.Builder(this, "ALARMFORSERVICE")
            .setSmallIcon(R.drawable.alarm_add)
            .setContentTitle("Будильник запущен")
            .setContentText("Он зазвонит в указанное время)")
            .build())
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_REDELIVER_INTENT
    }

    override fun startForegroundService(service: Intent?): ComponentName? {
        return super.startForegroundService(service)
    }

    override fun onDestroy() {
        this.stopSelf()
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? = null
}