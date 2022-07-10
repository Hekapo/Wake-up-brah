package ru.itis.wakeupbrah.features.set_alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.databinding.FragmentMainBinding
import ru.itis.wakeupbrah.myalarmclock.*
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val timeRepository = TimeRepository
    private var alarmManager: AlarmManager? = null
    private var pendingIntent: PendingIntent? = null
    private var calendar: Calendar? = null
    private var alarmChannel: AlarmChannel? = null
    private var alarmChannelForService: AlarmChannelForService? = null
    private var channel: CustomNotificationChannel? = null
    private val customAlarm = CustomAlarm()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        channel = CustomNotificationChannel()
        channel?.createChannel(context)

//        alarmChannel = AlarmChannel(requireContext()).also {
//            it.createNotificationChannel()
//        }
//        alarmChannelForService = AlarmChannelForService(requireContext()).also {
//            it.createNotificationChannel()
//        }
        begin()
    }

    private fun begin() {
        binding.showTime.setOnClickListener {
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            val materialTimePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Выберите время для будильника")
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

                timeRepository.saveTime(calendar, requireContext())
                binding.showTime.text = sdf.format(calendar.time).toString()
            }
            materialTimePicker.show(childFragmentManager, "tag_picker")
        }
        with(binding) {
            alarmButton.setOnClickListener {

                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
//                if (calendar != null) {
//                    alarmManager = Activity().getSystemService(ALARM_SERVICE) as AlarmManager
//                    pendingIntent =
//                        CustomAlarm(requireContext()).setAlarm(binding.root, calendar, alarmManager)
//                }
                Toast.makeText(
                    requireContext(),
                    "Будильник установлен на " + sdf.format(timeRepository.getTime(requireContext())),
                    Toast.LENGTH_SHORT
                ).show()
                customAlarm.setAlarm(requireContext(), timeRepository.getTime(requireContext()))

                findNavController().navigate(R.id.action_mainFragment_to_timePatternsFragmment)
            }
        }
        with(binding) {
            back.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_timePatternsFragmment)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
