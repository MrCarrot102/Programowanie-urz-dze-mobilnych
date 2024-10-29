package com.example.lista1;

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

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answersGroup;
    private Button nextButton;
    private ProgressBar progressBar;
    private TextView questionnumber; // Question counter

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.question_text);
        answersGroup = findViewById(R.id.answers_group);
        nextButton = findViewById(R.id.next_button);
        progressBar = findViewById(R.id.progress_bar);
        questionnumber = findViewById(R.id.question_counter); // Initialize question counter TextView

        questionList = generateQuestions();

        displayQuestion();

        nextButton.setOnClickListener(v -> {
            // Check if an answer is selected
            int selectedId = answersGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                int selectedAnswerIndex = answersGroup.indexOfChild(selectedRadioButton);

                // Check answer correctness
                if (selectedAnswerIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                    score += 10; // Add score
                }

                currentQuestionIndex++;

                // Update or end quiz
                if (currentQuestionIndex < questionList.size()) {
                    displayQuestion();
                } else {
                    showResult();
                }
            }
        });
    }

    // Generate list of questions
    private List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("2+2", new String[]{"4", "6", "8", "10"}, 0));
        questions.add(new Question("4*4", new String[]{"4", "16", "15", "12"}, 1));
        questions.add(new Question("5+5", new String[]{"14", "13", "15", "10"}, 3));
        questions.add(new Question("4/2", new String[]{"2", "4", "1", "9"}, 0));
        questions.add(new Question("10+10", new String[]{"21", "30", "20", "23"}, 2));
        questions.add(new Question("20*2", new String[]{"40", "50", "60", "30"}, 0));
        questions.add(new Question("100-50", new String[]{"50", "10", "15", "40"}, 0));
        questions.add(new Question("80/4", new String[]{"10", "20", "15", "25"}, 1));
        questions.add(new Question("50/5", new String[]{"10", "15", "20", "30"}, 0));
        questions.add(new Question("65/15", new String[]{"5", "4", "3", "2"}, 0));

        return questions;
    }

    // Display the current question
    private void displayQuestion() {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        questionText.setText(currentQuestion.getQuestion());

        // Update the question counter
        questionnumber.setText("Pytanie: " + (currentQuestionIndex + 1) + "/" + questionList.size());

        // Update answers
        for (int i = 0; i < answersGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) answersGroup.getChildAt(i);
            radioButton.setText(currentQuestion.getAnswers()[i]);
        }

        // Update progress bar
        progressBar.setProgress((int) ((currentQuestionIndex + 1) / (float) questionList.size() * 100));

        // Clear previous answer selection
        answersGroup.clearCheck();
    }

    // Display result after quiz ends
    private void showResult() {
        questionText.setText("Gratulacje! Zdobyłeś " + score + " pkt");
        nextButton.setVisibility(View.GONE); // Hide button after completion
        answersGroup.setVisibility(View.GONE); // Hide answer options
        questionnumber.setVisibility(View.GONE); // Hide question counter
    }
}
