package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button cheatButton;
    private TextView mQuestionTextView;
    private Question[] questionBank = new Question[]{new Question(R.string.question_oceans, true),
                                                    new Question(R.string.question_africa, false),
                                                    new Question(R.string.question_mideast, false),
                                                    new Question(R.string.question_americas, true),
                                                    new Question(R.string.question_asia, true)};
    private int mCurIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        cheatButton = (Button) findViewById(R.id.cheat_button);
        cheatButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               //start listening
               //creat enew intent to switch screens
               Intent i = new Intent(QuizActivity.this, CheatActivity.class);
               startActivity(i);

           }
        });
        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();


            }
        });
        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateQuestion();

            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();


            }
        });
        updateQuestion();
    }
    private void updateQuestion(){
        mCurIndex= (mCurIndex + 1) % questionBank.length;
        int question = questionBank[mCurIndex].getMtextId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = questionBank[mCurIndex].isMtrueAnswer();
        int messageResId = 0;
        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }
        else
            messageResId = R.string.incorrect_toast;
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
