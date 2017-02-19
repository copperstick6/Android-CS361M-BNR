package com.bignerdranch.android.geoquiz;

/**
 * Created by copperstick6 on 2/3/17.
 */

public class Question {
    private int mtextId;
    private boolean mtrueAnswer;
    public Question(int textResId, boolean answerTrue){
        this.mtextId = textResId;
        this.mtrueAnswer = answerTrue;
    }

    public int getMtextId() {
        return mtextId;
    }

    public boolean isMtrueAnswer() {
        return mtrueAnswer;
    }

    public void setMtrueAnswer(boolean mtrueAnswer) {
        this.mtrueAnswer = mtrueAnswer;
    }

    public void setMtextId(int mtextId) {
        this.mtextId = mtextId;
    }
}
