package com.example.onyenikelydia.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Onyenike Lydia on 6/22/2017.
 */

public class QuizListAdapter extends BaseAdapter {
    private List<QuizItemStructure> QuizList;
    private Context context;
    public int[] answers;

    public QuizListAdapter(List<QuizItemStructure> Quizitem, Context context) {
        this.QuizList = Quizitem;
        this.context = context;
        answers = new int[this.QuizList.size()];
    }

    @Override
    public int getCount() {
        return this.QuizList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.QuizList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        QuizItemStructure quizItemStructure = this.QuizList.get(position);
        if (convertView == null) {
            LayoutInflater inflater = ((AppCompatActivity) this.context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_quiz_item, parent, false);
        }
        TextView serialnumber = (TextView) convertView.findViewById(R.id.serialNumber);
        serialnumber.setText(quizItemStructure.serialNumber);

        TextView question = (TextView) convertView.findViewById(R.id.Question);
        question.setText(quizItemStructure.Question);

        RadioButton optionOne = (RadioButton) convertView.findViewById(R.id.option1);
        optionOne.setText(quizItemStructure.option1);
        optionOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answers[position] = 1;
                }
            }
        });

        RadioButton optionTwo = (RadioButton) convertView.findViewById(R.id.option2);
        optionTwo.setText(quizItemStructure.option2);
        optionTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answers[position] = 2;
                }
            }
        });

        RadioButton optionThree = (RadioButton) convertView.findViewById(R.id.option3);
        optionThree.setText(quizItemStructure.option3);
        optionThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answers[position] = 3;
                }
            }
        });

        RadioButton optionFour = (RadioButton) convertView.findViewById(R.id.option4);
        optionFour.setText(quizItemStructure.option4);
        optionFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answers[position] = 4;
                }
            }
        });

        switch (answers[position]){
            case 0:default:{
                optionOne.setChecked(false);
                optionTwo.setChecked(false);
                optionThree.setChecked(false);
                optionFour.setChecked(false);
            }
            case 1: {
                optionOne.setChecked(true);
                optionTwo.setChecked(false);
                optionThree.setChecked(false);
                optionFour.setChecked(false);
            }
            case 2:{
                optionOne.setChecked(false);
                optionTwo.setChecked(true);
                optionThree.setChecked(false);
                optionFour.setChecked(false);
            }
            case 3:{
                optionOne.setChecked(false);
                optionTwo.setChecked(false);
                optionThree.setChecked(true);
                optionFour.setChecked(false);
            }
            case 4:{
                optionOne.setChecked(false);
                optionTwo.setChecked(false);
                optionThree.setChecked(false);
                optionFour.setChecked(true);
            }
        }

        RadioGroup radioGroup = (RadioGroup) convertView.findViewById(R.id.radioGroup);

        return convertView;
    }

    public String mark() {
        Integer totalScore = 0;
        for (int i = 0; i < this.QuizList.size(); i++) {
            QuizItemStructure item = this.QuizList.get(i);
            if (item.correctOption == answers[i]) {
                totalScore++;
            }
        }

        return "" + totalScore + "/" + this.QuizList.size();
    }
}
