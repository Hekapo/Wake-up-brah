package ru.itis.wakeupbrah


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.wakeupbrah.databinding.FragmentStartedBinding


class StartedFragment : Fragment(R.layout.fragment_started) {

    private var _binding: FragmentStartedBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStartedBinding.bind(view)

        with(binding){
            btnAlarm.setOnClickListener {
                findNavController().navigate(R.id.action_startedFragment_to_mainFragment)
            }
        }
        with(binding){
            btnReminder.setOnClickListener {
                findNavController().navigate(R.id.action_startedFragment_to_reminderFragment)
            }
        }
        with(binding){
            btnSmart.setOnClickListener {
                findNavController().navigate(R.id.action_startedFragment_to_smartFragment)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}