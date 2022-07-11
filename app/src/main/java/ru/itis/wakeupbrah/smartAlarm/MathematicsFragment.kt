package ru.itis.wakeupbrah

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.itis.wakeupbrah.databinding.FragmentMathematicsBinding
import ru.itis.wakeupbrah.smartAlarm.SmartActivity
import java.util.*

class MathematicsFragment: Fragment(R.layout.fragment_mathematics) {
    private var _binding: FragmentMathematicsBinding? = null
    private val binding get() = _binding!!
    private val smartActivity: SmartActivity
        get() = requireActivity() as SmartActivity
    private val mathematics = Questions()

    private val mathematicsLength: Int = mathematics.mathematics.size

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMathematicsBinding.bind(view)
        val rand = Random()
        var id:Int = rand.nextInt(mathematicsLength)

        NextRiddle(id)


        binding.btnEnterMathematics.setOnClickListener {
            val result:String = binding.etAnswerMathematics.text.toString()
            if(result == getString(mathematics.getMathematicsCorrectAnswer(id))){
                Toast.makeText(activity, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
                smartActivity.onDestroy()
            } else {
                Toast.makeText(activity, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
                id = rand.nextInt(mathematicsLength)
                NextRiddle(id)
                binding.etAnswerMathematics.text?.clear()
            }
        }

    }

    private fun NextRiddle(num: Int) {
        with(binding){
            tvMathematicsQuestion.text = getString(mathematics.getMathematics(num))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}