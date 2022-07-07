package com.example.myalarmclock

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.wakeupbrah.databinding.FragmentMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.example.myalarmclock.CustomNotification
import ru.itis.wakeupbrah.R
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val timeRepository = TimeRepository()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.showTime.setOnClickListener {
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            val materialTimePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Выберите время для будильника")
                .build()


            materialTimePicker.addOnPositiveButtonClickListener {
                val calendar = Calendar.getInstance()
                calendar[Calendar.SECOND] = 0
                calendar[Calendar.MILLISECOND] = 0
                calendar[Calendar.MINUTE] = materialTimePicker.minute
                calendar[Calendar.HOUR_OF_DAY] = materialTimePicker.hour
                val now: Calendar = Calendar.getInstance()
                if (calendar.before(now)){ calendar.add(Calendar.DAY_OF_MONTH, 1)}

                timeRepository.saveTime(calendar, requireContext())
                binding.showTime.text = sdf.format(calendar.time).toString()
            }
            materialTimePicker.show(childFragmentManager, "tag_picker")
        }


        with(binding){
            alarmButton.setOnClickListener {

                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                CustomAlarm().setAlarm(requireContext(),timeRepository.getTime(requireContext()))
                Toast.makeText(
                    requireContext(),
                    "Будильник установлен на " + sdf.format(timeRepository.getTime(requireContext())),
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_mainFragment_to_timePatternsFragmment)
            }
        }
        with(binding){
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
