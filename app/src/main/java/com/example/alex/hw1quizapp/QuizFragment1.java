package com.example.alex.hw1quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class QuizFragment1 extends Fragment{

    boolean q1correct = true;
    private Button enterButton;
    private EditText edittext;
    private String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quiz_fragment1, container, false);
        enterButton = (Button)  view.findViewById(R.id.enterButton);
        edittext    = (EditText)view.findViewById(R.id.editText);

        edittext.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            checkInput();
                            handled = true;
                        }
                        return handled;
                    }
                }
        );
        enterButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO: Get text from edit text and check if it is correct
                        checkInput();
                        //getFragmentManager().beginTransaction().addToBackStack(null);

                    }
                }
        );
        return view;

    }

    private void checkInput(){
        text = edittext.getText().toString().replaceAll("\\s+","");//removes all spaces
        q1correct = text.equalsIgnoreCase("tobias") || text.equalsIgnoreCase("davidcross");


        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuizFragment2().newInstance(q1correct)).commit();
    }

}
