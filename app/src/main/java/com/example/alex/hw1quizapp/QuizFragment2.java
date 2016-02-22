package com.example.alex.hw1quizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class QuizFragment2 extends Fragment {

    //Declare Variables
    private static final String ARG_PARAM1 = "param1";
    private Button submit;
    private View view;
    private boolean q2right = false;
    private CheckBox ch1 = null;
    private CheckBox ch2 = null;
    private CheckBox ch3 = null;
    private CheckBox ch4 = null;
    private CheckBox ch5 = null;
    private boolean mParam1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view    =  inflater.inflate(R.layout.fragment_quiz_fragment2, container, false);
        submit  = (Button) view.findViewById(R.id.submitQ2);
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        q2right = checkBoxes(view);
                        open();
                    }
                }
        );
        return view;
    }


    // TODO: Rename and change types and number of parameters
    public static QuizFragment2 newInstance(boolean param1) {
        QuizFragment2 fragment = new QuizFragment2();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getBoolean(ARG_PARAM1);
        }
    }


    private boolean checkBoxes(View view){
        boolean correct;
        ch1 = (CheckBox)view.findViewById(R.id.checkBox);
        ch2 = (CheckBox)view.findViewById(R.id.checkBox2);
        ch3 = (CheckBox)view.findViewById(R.id.checkBox3);
        ch4 = (CheckBox)view.findViewById(R.id.checkBox4);
        ch5 = (CheckBox)view.findViewById(R.id.checkBox5);
        if(ch1 == null || ch2 == null || ch3 == null || ch4 == null || ch5 == null)
            correct = false;
        else
            correct = !ch1.isChecked() && ch2.isChecked() && ch3.isChecked() && ch4.isChecked() && !ch5.isChecked();
        return correct;
    }


    private void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        /* Logic for answer correctness*/
        if(q2right && mParam1)
            alertDialogBuilder.setMessage("Question 1: Correct \nQuestion 2: Correct \nWould you like to retake the quiz?");
        else if(mParam1 && !q2right)
            alertDialogBuilder.setMessage("Question 1: Correct\nQuestion 2: Incorrect \nWould you like to retake the quiz?");
        else if(q2right && !mParam1)
            alertDialogBuilder.setMessage("Question 1: Incorrect\nQuestion 2: Correct \nWould you like to retake the quiz?");
        else
            alertDialogBuilder.setMessage("Question 1: Incorrect\nQuestion 2: Incorrect \nWould you like to retake the quiz?");
        //sets the functionality of "Yes"
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getActivity(), "Good luck", Toast.LENGTH_LONG).show();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new QuizFragment1()).commit();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
