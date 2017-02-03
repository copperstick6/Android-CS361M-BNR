package com.bignerdranch.android.geoquiz;

/**
 * Created by copperstick6 on 2/3/17.
 */

public class Question {
    private int mtextId;
    private boolean mtrueAnswer;
    private Question(int textResId, boolean answerTrue){
        this.mtextId = textResId;
        this.mtrueAnswer = answerTrue;
    }
}
