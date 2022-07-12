package ru.itis.wakeupbrah.myReminder

import android.content.SharedPreferences
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.wakeupbrah.myalarmclock.CustomReminder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.databinding.FragmentMainBinding
import ru.itis.wakeupbrah.databinding.FragmentReminderBinding
import ru.itis.wakeupbrah.myalarmclock.*
import java.text.SimpleDateFormat
import java.util.*

class ReminderFragment : Fragment(R.layout.fragment_reminder) {

    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!
    private val reminderTimeRepository = ReminderTimeRepository
    private val reminderRepository = ReminderRepository
    private var channel: ReminderCustomNotificationChannel? = null
    private val customReminder = CustomReminder()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = FragmentReminderBinding.bind(view)

        channel = ReminderCustomNotificationChannel()
        channel?.createChannel(context)


        begin()
    }

    private fun begin() {
        binding.showTime.setOnClickListener {
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            val materialTimePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Выберите время для напоминания")
                .build()

            materialTimePicker.addOnPositiveButtonClickListener {
                val calendar = Calendar.getInstance().also {
                    it[Calendar.HOUR_OF_DAY] = materialTimePicker.hour
                    it[Calendar.MINUTE] = materialTimePicker.minute
                    it[Calendar.SECOND] = 0
                    it[Calendar.MILLISECOND] = 0
                }
                val now: Calendar = Calendar.getInstance()
                if (calendar.before(now)) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }

                reminderTimeRepository.saveTime(calendar, requireContext())
                binding.showTime.text = sdf.format(calendar.time).toString()
            }
            materialTimePicker.show(childFragmentManager, "tag_picker")
        }
        with(binding) {
            reminderButton.setOnClickListener {
                val rem = binding.showReminder.text
                reminderRepository.saveReminder(rem.toString(), requireContext())

                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())

                Toast.makeText(
                    requireContext(),
                    "Напоминание придёт в " + sdf.format(reminderTimeRepository.getTime(requireContext())),
                    Toast.LENGTH_SHORT
                ).show()
                customReminder.setAlarm(requireContext(), reminderTimeRepository.getTime(requireContext()))

                findNavController().navigate(R.id.action_reminderFragment_to_startedFragment)
            }
        }
        with(binding) {
            back.setOnClickListener {
                findNavController().navigate(R.id.action_reminderFragment_to_startedFragment)
            }

        }
        with(binding) {
            removeReminder.setOnClickListener {
                customReminder.cancelAlarm(requireContext())
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
