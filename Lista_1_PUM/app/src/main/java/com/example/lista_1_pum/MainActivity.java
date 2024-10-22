package com.example.lista_1_pum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActiovity extends AppCompatActivity{
    private TextView questionText;
    private RadioGroup answersGroup;
    private Button nextButton;
    private ProgressBar progressBar;

    private List<Question> questionList;
    private int currentQuestionIndex=0;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText=findViewById(R.id.question_text);
        answersGroup=findViewById(R.id.answer_group);
        nextButton=findViewById(R.id.next_button);
        progressBar=findViewById(R.id.progres_bar);

        questionList=generateQueston();
        displayQuestion();
        nextButton.setOnClickListener(v->{
            int selectedId=answersGroup.getCheckedRadioButtonId();
            if(selectedId != -1){
                RadioButton selectedRadioButton=findViewById(selectedId);
                int selectedAndsweIndex=answersGroup.indexOfChild(selectedRadioButton);
                // sprawdzanie poprawnosci odpowiedzi
                if(selectedAndsweIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()){
                    score += 10;
                }
                currentQuestionIndex++;
                // aktualizacja gry (nastepne pytanie albo koniec)
                if(currentQuestionIndex < questionList.size()){
                    displayQuestion();
                } else {
                    showResult();
                }
            }
        });
    }

    private void initializeQuestions() {
        questionList=new ArrayList<>();
        questionList.add(new Question("2+2",
            new String[]{"4","5","6","7"}, 1));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
        questionList.add(new Question("3+3",
                new String[]{"5","6","7","8"},2));
    }
    Private void loadQuestion(){
        radioGroup.clearCheck();
        Question currentQuestion=questionList.get(currentQuestonIndex);
        tvQuestion.setText(currentQuestion.getQuestionText());
        String[] options=currentQuestion.getOptions();
        rbOption1.setText(option[0]);
        rbOption2.
    }

}