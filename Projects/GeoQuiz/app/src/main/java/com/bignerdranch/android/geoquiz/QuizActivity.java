package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
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
        int question = questionBank[mCurIndex].getMtextId();
        mQuestionTextView.setText(question);
        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();


            }
        });
        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurIndex= (mCurIndex + 1) % questionBank.length;
                int question = questionBank[mCurIndex].getMtextId();
                mQuestionTextView.setText(question);

            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();


            }
        });
    }

}
