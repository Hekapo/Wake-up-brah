package ru.itis.wakeupbrah

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.itis.wakeupbrah.databinding.FragmentEnterAnswerBinding
import ru.itis.wakeupbrah.smartAlarm.SmartActivity
import java.util.*


class EnterAnswerFragment: Fragment(R.layout.fragment_enter_answer) {
    private var _binding: FragmentEnterAnswerBinding? = null
    private val binding get() = _binding!!
    private val smartActivity: SmartActivity
        get() = requireActivity() as SmartActivity
    private val riddles = Questions()

    private val riddleLength: Int = riddles.riddles.size


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEnterAnswerBinding.bind(view)

        val rand = Random()
        var id:Int = rand.nextInt(riddleLength)

        NextRiddle(id)
        Log.e("check", "${id}")

        var counter:Int = 0

        binding.btnEnter.setOnClickListener {
            val result:String = binding.edtAnswer.text.toString().lowercase()
            if(result == getString(riddles.getRiddleCorrectAnswer(id))){
                Toast.makeText(activity, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show();
                counter++
                binding.tvCorrectAnswers.text = "Правильные ответы: ${counter}/3"
                if(counter!=3){
                    id = rand.nextInt(riddleLength)
                    Log.e("check", "${id}")
                    NextRiddle(id)
                    binding.edtAnswer.text?.clear()
                } else {
                    smartActivity.onDestroy()
                }
            } else {
                Toast.makeText(activity, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
                id = rand.nextInt(riddleLength)
                Log.e("check", "${id}")
                NextRiddle(id)
                binding.edtAnswer.text?.clear()
            }
        }

    }

    private fun NextRiddle(num: Int) {
        with(binding){
            tvQuestion.text = getString(riddles.getRiddle(num))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}