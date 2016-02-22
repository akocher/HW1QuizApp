package com.example.alex.hw1quizapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizFragment2 extends Fragment {
    private Button submit;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_quiz_fragment2, container, false);
        submit= (Button) view.findViewById(R.id.submitQ2);
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //do nothing
                    }
                }
        );

        return view;
    }
}
