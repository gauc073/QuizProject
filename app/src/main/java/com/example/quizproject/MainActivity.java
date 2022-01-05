package com.example.quizproject;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    // setting up things
    private TextView questionTV, questionNumberTV, answerCorrectCount;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up the buttons
        // associated with id
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        answerCorrectCount = findViewById(R.id.idTVQuestionCorrectCount);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().toLowerCase().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().toLowerCase().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().toLowerCase().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().toLowerCase().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });


    }

    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Question Attempted: " + questionAttempted +"/10");
        answerCorrectCount.setText("Correct Answer: " + currentScore);
        questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
        option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
        option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
        option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
        option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());

    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("Question1", "option1", "Correct Answer", "option3", "option4", "Correct Answer"));
        quizModelArrayList.add(new QuizModel("Question2", "Correct Answer", "option2", "option3", "option4", "Correct Answer"));
        quizModelArrayList.add(new QuizModel("Question3", "option1", "option2", "Correct Answer", "option4", "Correct Answer"));
        quizModelArrayList.add(new QuizModel("Question4", "option1", "option2", "option3", "Correct Answer", "Correct Answer"));
        quizModelArrayList.add(new QuizModel("Question5", "option1", "option2", "Correct Answer", "option4", "Correct Answer"));
        quizModelArrayList.add(new QuizModel("Question6", "Correct Answer", "option2", "option3", "option4", "Correct Answer"));

    }
}
