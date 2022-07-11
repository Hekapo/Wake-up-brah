package ru.itis.wakeupbrah.smartAlarm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.itis.wakeupbrah.Questions
import ru.itis.wakeupbrah.R
import ru.itis.wakeupbrah.databinding.FragmentChooseAnswerBinding
import java.util.*

class ChooseAnswerFragment : Fragment(R.layout.fragment_choose_answer) {

    private var _binding: FragmentChooseAnswerBinding? = null
    private val binding get() = _binding!!
    private val smartActivity: SmartActivity
        get() = requireActivity() as SmartActivity
    private val questions = Questions()

    private var answer: String? = null
    private val questionLength: Int = questions.questions.size

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChooseAnswerBinding.bind(view)

        val rand = Random()
        var id:Int = rand.nextInt(questionLength)
        NextQuestion(id)

        val activity: FragmentActivity? = getActivity()

        var counter:Int = 0

        binding.btnOne.setOnClickListener {
            if(binding.btnOne.text == answer){
                Toast.makeText(activity, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
                counter++
                binding.tvCorrectAnswers.text = "Правильные ответы: ${counter}/3"
                if(counter!=3){
                    id = rand.nextInt(questionLength)
                    NextQuestion(id)
                } else {
                    smartActivity.onDestroy()
                }
            } else {
                Toast.makeText(activity, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
                NextQuestion(rand.nextInt(questionLength))
            }
        }

        binding.btnTwo.setOnClickListener {
            if(binding.btnTwo.text == answer){
                Toast.makeText(activity, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
                counter++
                binding.tvCorrectAnswers.text = "Правильные ответы: ${counter}/3"
                if(counter!=3){
                    id = rand.nextInt(questionLength)
                    NextQuestion(id)
                } else {
                    smartActivity.onDestroy()
                }
            } else {
                Toast.makeText(activity, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
                NextQuestion(rand.nextInt(questionLength))
            }
        }

        binding.btnThree.setOnClickListener {
            if(binding.btnThree.text == answer){
                Toast.makeText(activity, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
                counter++
                binding.tvCorrectAnswers.text = "Правильные ответы: ${counter}/3"
                if(counter!=3){
                    id = rand.nextInt(questionLength)
                    NextQuestion(id)
                } else {
                    smartActivity.onDestroy()
                }
            } else {
                Toast.makeText(activity, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
                NextQuestion(rand.nextInt(questionLength))
            }
        }

        binding.btnFour.setOnClickListener {
            if(binding.btnFour.text == answer){
                Toast.makeText(activity, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
                counter++
                binding.tvCorrectAnswers.text = "Правильные ответы: ${counter}/3"
                if(counter!=3){
                    id = rand.nextInt(questionLength)
                    NextQuestion(id)
                } else {
                    smartActivity.onDestroy()
                }
            } else {
                Toast.makeText(activity, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
                NextQuestion(rand.nextInt(questionLength))
            }
        }

    }

    private fun NextQuestion(num: Int) {
        with(binding){
            tvQuestion.text = getString(questions.getQuestion(num))
            btnOne.text = getString(questions.getchoice1(num))
            btnTwo.text = getString(questions.getchoice2(num))
            btnThree.text = getString(questions.getchoice3(num))
            btnFour.text = getString(questions.getchoice4(num))
            answer = getString(questions.getQuestionCorrectAnswer(num))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}