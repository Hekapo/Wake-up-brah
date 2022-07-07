package ru.itis.wakeupbrah.myalarmclock.time_patterns

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.databinding.FragmentMainBinding
import ru.itis.wakeupbrah.databinding.FragmentTimePetternsBinding

class TimePatternsFragment: Fragment(R.layout.fragment_time_petterns) {
    private var _binding: FragmentTimePetternsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTimePetternsBinding.bind(view)
        with(binding){
            newAlarm.setOnClickListener {
                findNavController().navigate(R.id.action_timePatternsFragmment_to_mainFragment)
            }
        }
    }


}