package ru.itis.wakeupbrah

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.wakeupbrah.databinding.FragmentMain2Binding


class MainFragment2: Fragment(R.layout.fragment_main2)  {
    private var _binding: FragmentMain2Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMain2Binding.bind(view)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_questionFragment, null)
        }

        binding.btnStart2.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_enterAnswerFragment, null)
        }

        binding.btnStart3.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_mathematicsFragment, null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}