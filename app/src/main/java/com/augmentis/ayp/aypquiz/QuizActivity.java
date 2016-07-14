package com.augmentis.ayp.aypquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Button trueButton;
    Button falseButton;

    Button nextButton;
    TextView questionText;

    Question[] questions = new Question[] {
            new Question(R.string.question_1_nile, true),
            new Question(R.string.question_2_rawin, true),
            new Question(R.string.question_3_math, false),
            new Question(R.string.question_4_mars, false)
    };

    int currentIndex; //set question display number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        questionText = (TextView) findViewById(R.id.text_question);

        currentIndex = 0;
        questionText.setText(questions[currentIndex].getQuestionId());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click true
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click false
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (currentIndex < (questions.length - 1)) { //0 1 2
//                    currentIndex++;
//                } else {
//                    currentIndex = 0;
//                }
//                questionText.setText(questions[currentIndex].getQuestionId());

//                currentIndex = (currentIndex+1) % questions.length;
//                questionText.setText(questions[currentIndex].getQuestionId());

                currentIndex = (++currentIndex) % questions.length;
                questionText.setText(questions[currentIndex].getQuestionId());
            }
        });
    }

    private void checkAnswer(boolean answer) {

        boolean currentAnswer = questions[currentIndex].getAnswer();

//        if (answer == currentAnswer) {
//            Toast.makeText(QuizActivity.this, R.string.correct_text,  Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(QuizActivity.this, R.string.incorrect_text,  Toast.LENGTH_SHORT).show();
//        }

        int result = (answer == currentAnswer) ? R.string.correct_text : R.string.incorrect_text;
        Toast.makeText(QuizActivity.this, result,  Toast.LENGTH_SHORT).show();

//        if(answer == currentAnswer){
//            result = R.string.correct_text;
//        } else {
//            result = R.string.incorrect_text;
//        }
//        Toast.makeText(QuizActivity.this, result,  Toast.LENGTH_SHORT).show();
    }

}