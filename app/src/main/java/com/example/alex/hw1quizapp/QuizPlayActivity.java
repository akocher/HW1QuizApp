package com.example.alex.hw1quizapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class QuizPlayActivity extends FragmentActivity //implements QuizFragment1.OnFragmentInteractionListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_quiz_play_activitiy);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new QuizFragment1()).commit();

    }
}
