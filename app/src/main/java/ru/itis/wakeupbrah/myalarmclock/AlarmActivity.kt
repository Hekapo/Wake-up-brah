package com.example.myalarmclock

import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ru.itis.wakeupbrah.R
import java.text.SimpleDateFormat
import java.util.*


class AlarmActivity : AppCompatActivity() {
    private var button: Button? = null
    var ringtone: Ringtone? = null
    private var textTime: TextView? = null
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val now: Calendar = Calendar.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        var notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ringtone = RingtoneManager.getRingtone(this, notificationUri)
        if (ringtone == null) {
            notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
            ringtone = RingtoneManager.getRingtone(this, notificationUri)
        }
        if (ringtone != null) {
            ringtone!!.isLooping = true
            ringtone!!.play()
        }

        button = findViewById(R.id.btn_off)
        textTime = findViewById(R.id.textTime)
        textTime?.text = sdf.format(now.time).toString()
        button?.setOnClickListener {
            ringtone!!.stop()
            finish()
        }
    }

    override fun onDestroy() {
        if (ringtone != null && ringtone!!.isPlaying) {
            ringtone!!.stop()
        }
        super.onDestroy()
    }
}