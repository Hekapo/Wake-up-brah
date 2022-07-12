package ru.itis.wakeupbrah.myReminder

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.wakeupbrah.smartAlarm.CustomSmart
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.databinding.FragmentReminderBinding
import ru.itis.wakeupbrah.databinding.FragmentSmartBinding
import ru.itis.wakeupbrah.myalarmclock.*
import java.text.SimpleDateFormat
import java.util.*

class SmartFragment : Fragment(R.layout.fragment_smart) {

    private var _binding: FragmentSmartBinding? = null
    private val binding get() = _binding!!
    private val smartTimeRepository = SmartTimeRepository
    private var channel: SmartCustomNotificationChannel? = null
    private val customSmart = CustomSmart()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = FragmentSmartBinding.bind(view)

        channel = SmartCustomNotificationChannel()
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

                smartTimeRepository.saveTime(calendar, requireContext())
                binding.showTime.text = sdf.format(calendar.time).toString()
            }
            materialTimePicker.show(childFragmentManager, "tag_picker")
        }
        with(binding) {
            alarmButton.setOnClickListener {

                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())

                Toast.makeText(
                    requireContext(),
                    "Будильник прозвенит в " + sdf.format(smartTimeRepository.getTime(requireContext())),
                    Toast.LENGTH_SHORT
                ).show()
                customSmart.setAlarm(requireContext(), smartTimeRepository.getTime(requireContext()))

                findNavController().navigate(R.id.action_smartFragment_to_startedFragment)
            }
        }
        with(binding) {
            back.setOnClickListener {
                findNavController().navigate(R.id.action_smartFragment_to_startedFragment)
            }

        }
        with(binding) {
            alarmRemove.setOnClickListener {
                customSmart.cancelAlarm(requireContext())
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
