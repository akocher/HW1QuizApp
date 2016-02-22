package com.example.alex.hw1quizapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;
import android.app.Fragment;

public class QuizPlayActivity extends FragmentActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_play_activity);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new QuizFragment1()).commit();
        getFragmentManager().beginTransaction().addToBackStack(null);
    }
}
