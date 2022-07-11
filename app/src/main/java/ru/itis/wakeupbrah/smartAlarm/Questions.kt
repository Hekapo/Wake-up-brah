package ru.itis.wakeupbrah

import android.content.res.Resources

class Questions {
    val questions:Array<Int> = arrayOf (
        R.string.question1,
        R.string.question2,
        R.string.question3,
        R.string.question4,
        R.string.question5,
        R.string.question6,
        R.string.question7,
        R.string.question8,
        R.string.question9,
        R.string.question10,
        R.string.question11,
        R.string.question12,
        R.string.question13,
        R.string.question14,
        R.string.question15
    );

    val riddles:Array<Int> = arrayOf (
        R.string.riddle1,
        R.string.riddle2,
        R.string.riddle3,
        R.string.riddle4,
        R.string.riddle5,
        R.string.riddle6,
        R.string.riddle7,
        R.string.riddle8,
        R.string.riddle9,
        R.string.riddle10,
        R.string.riddle11,
        R.string.riddle12,
        R.string.riddle13,
        R.string.riddle14,
        R.string.riddle15
    );

    val mathematics:Array<Int> = arrayOf (
        R.string.mathematics1,
        R.string.mathematics2,
        R.string.mathematics3,
        R.string.mathematics4,
        R.string.mathematics5,
        R.string.mathematics6,
        R.string.mathematics7,
        R.string.mathematics8,
        R.string.mathematics9,
        R.string.mathematics10
    );

    val choices: Array<Array<Int>> = arrayOf<Array<Int>>(
        arrayOf(R.string.question1_choice1, R.string.question1_choice2, R.string.question1_choice3, R.string.question1_choice4),
        arrayOf(R.string.question2_choice1, R.string.question2_choice2, R.string.question2_choice3, R.string.question2_choice4),
        arrayOf(R.string.question3_choice1, R.string.question3_choice2, R.string.question3_choice3, R.string.question3_choice4),
        arrayOf(R.string.question4_choice1, R.string.question4_choice2, R.string.question4_choice3, R.string.question4_choice4),
        arrayOf(R.string.question5_choice1, R.string.question5_choice2, R.string.question5_choice3, R.string.question5_choice4),
        arrayOf(R.string.question6_choice1, R.string.question6_choice2, R.string.question6_choice3, R.string.question6_choice4),
        arrayOf(R.string.question7_choice1, R.string.question7_choice2, R.string.question7_choice3, R.string.question7_choice4),
        arrayOf(R.string.question8_choice1, R.string.question8_choice2, R.string.question8_choice3, R.string.question8_choice4),
        arrayOf(R.string.question9_choice1, R.string.question9_choice2, R.string.question9_choice3, R.string.question9_choice4),
        arrayOf(R.string.question10_choice1, R.string.question10_choice2, R.string.question10_choice3, R.string.question10_choice4),
        arrayOf(R.string.question11_choice1, R.string.question11_choice2, R.string.question11_choice3, R.string.question11_choice4),
        arrayOf(R.string.question12_choice1, R.string.question12_choice2, R.string.question12_choice3, R.string.question12_choice4),
        arrayOf(R.string.question13_choice1, R.string.question13_choice2, R.string.question13_choice3, R.string.question13_choice4),
        arrayOf(R.string.question14_choice1, R.string.question14_choice2, R.string.question14_choice3, R.string.question14_choice4),
        arrayOf(R.string.question15_choice1, R.string.question15_choice2, R.string.question15_choice3, R.string.question15_choice4))

    val questionCorrectAnswer:Array<Int> = arrayOf(
        R.string.question1_choice4,
        R.string.question2_choice2,
        R.string.question3_choice3,
        R.string.question4_choice4,
        R.string.question5_choice2,
        R.string.question6_choice2,
        R.string.question7_choice1,
        R.string.question8_choice4,
        R.string.question9_choice3,
        R.string.question10_choice3,
        R.string.question11_choice1,
        R.string.question12_choice2,
        R.string.question13_choice4,
        R.string.question14_choice4,
        R.string.question14_choice1
        )

    val riddleCorrectAnswer:Array<Int> = arrayOf(
        R.string.riddle1_answer,
        R.string.riddle2_answer,
        R.string.riddle3_answer,
        R.string.riddle4_answer,
        R.string.riddle5_answer,
        R.string.riddle6_answer,
        R.string.riddle7_answer,
        R.string.riddle8_answer,
        R.string.riddle9_answer,
        R.string.riddle10_answer,
        R.string.riddle11_answer,
        R.string.riddle12_answer,
        R.string.riddle13_answer,
        R.string.riddle14_answer,
        R.string.riddle15_answer
    )

    val mathematicsCorrectAnswer:Array<Int> = arrayOf(
        R.string.mathematics1_answer,
        R.string.mathematics2_answer,
        R.string.mathematics3_answer,
        R.string.mathematics4_answer,
        R.string.mathematics5_answer,
        R.string.mathematics6_answer,
        R.string.mathematics7_answer,
        R.string.mathematics8_answer,
        R.string.mathematics9_answer,
        R.string.mathematics10_answer
    )

    fun getQuestion(a: Int): Int{
        val question:Int = questions[a];
        return question;
    }

    fun getRiddle(a: Int): Int{
        val riddle:Int = riddles[a];
        return riddle;
    }

    fun getMathematics(a: Int): Int{
        val mathematic:Int = mathematics[a];
        return mathematic;
    }

    fun getchoice1(a: Int): Int{
        val choice:Int = choices[a] [0];
        return choice;
    }

    fun getchoice2(a: Int): Int{
        val choice:Int = choices[a] [1];
        return choice;
    }

    fun getchoice3(a: Int): Int{
        val choice:Int = choices[a] [2];
        return choice;
    }

    fun getchoice4(a: Int): Int{
        val choice:Int = choices[a] [3];
        return choice;
    }

    fun getQuestionCorrectAnswer(a: Int): Int{
        val answer:Int = questionCorrectAnswer[a];
        return answer;
    }

    fun getRiddleCorrectAnswer(a: Int): Int{
        val answer:Int = riddleCorrectAnswer[a];
        return answer;
    }

    fun getMathematicsCorrectAnswer(a: Int): Int{
        val answer:Int = mathematicsCorrectAnswer[a];
        return answer;
    }
}