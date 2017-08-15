package com.example.onyenikelydia.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.onyenikelydia.quizapp.R.id.Question;

public class QuizActivity extends AppCompatActivity {
    private QuizListAdapter QuizArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);
        QuizArrayAdapter = new QuizListAdapter(getQuizitem(), this);
        listView.setAdapter(QuizArrayAdapter);

        Button submitButton = (Button) findViewById(R.id.nextButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mark();
            }
        });
    }

    private void mark() {
        String markInfo = QuizArrayAdapter.mark();
        TextView infoTextView = (TextView) findViewById(R.id.textViewScores);
        infoTextView.setText(markInfo);
    }

    private List<QuizItemStructure> getQuizitem(){
        QuizItemStructure Question1 = new QuizItemStructure();
        Question1.serialNumber = "1";
        Question1.Question = "Roughly what proportion of the world's population is fluent or competent in English?";
        Question1.option1 = "   One person in a thousand";
        Question1.option2 = "   One in a hundred";
        Question1.option3 = "   One in ten";
        Question1.option4 = "   One in four";
        Question1.correctOption = 4;

        QuizItemStructure Question2 = new QuizItemStructure();
        Question2.serialNumber = "2";
        Question2.Question = "Which of the following is probably the most widely used English word throughout the world?";
        Question2.option1 = "   The";
        Question2.option2 = "   Okay";
        Question2.option3 = "   Sex";
        Question2.option4 = "   To";
        Question2.correctOption = 2;

        QuizItemStructure Question3 = new QuizItemStructure();
        Question3.serialNumber = "3";
        Question3.Question = "Which country contains the largest English - speaking population in the world?";
        Question3.option1 = "   England";
        Question3.option2 = "   The United States";
        Question3.option3 = "   China";
        Question3.option4 = "   India";
        Question3.correctOption = 4;

        QuizItemStructure Question4 = new QuizItemStructure();
        Question4.serialNumber = "4";
        Question4.Question = "In approximately how many countries does the English Language have official or special status?";
        Question4.option1 = "   10";
        Question4.option2 = "   15";
        Question4.option3 = "   50";
        Question4.option4 = "   75";
        Question4.correctOption = 4;

        QuizItemStructure Question5 = new QuizItemStructure();
        Question5.serialNumber = "5";
        Question5.Question = "Which one of the following words is an example of an isogram?";
        Question5.option1 = "   destruction";
        Question5.option2 = "   palindrome";
        Question5.option3 = "   sesquipedalian";
        Question5.option4 = "   racecar";
        Question5.correctOption = 2;


        List<QuizItemStructure> Quizitem = new ArrayList<>();
        Quizitem.add(Question1);
        Quizitem.add(Question2);
        Quizitem.add(Question3);
        Quizitem.add(Question4);
        Quizitem.add(Question5);
        return Quizitem;
    }

}
