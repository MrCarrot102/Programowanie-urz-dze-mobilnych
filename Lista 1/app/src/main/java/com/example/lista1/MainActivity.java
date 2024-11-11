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

    // TextView do wyświetlania treści pytania
    private TextView questionText;
    // RadioGroup do przechowywania przycisków z odpowiedziami
    private RadioGroup answersGroup;
    // Przycisk do przejścia do następnego pytania
    private Button nextButton;
    // Pasek postępu, który pokazuje postęp w quizie
    private ProgressBar progressBar;
    // TextView do wyświetlania numeru aktualnego pytania
    private TextView questionnumber;

    // Lista przechowująca pytania
    private List<Question> questionList;
    // Indeks aktualnego pytania
    private int currentQuestionIndex = 0;
    // Wynik uzyskany przez użytkownika
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja elementów interfejsu użytkownika
        questionText = findViewById(R.id.question_text);
        answersGroup = findViewById(R.id.answers_group);
        nextButton = findViewById(R.id.next_button);
        progressBar = findViewById(R.id.progress_bar);
        questionnumber = findViewById(R.id.question_counter); // Inicjalizacja licznika pytań

        // Generowanie pytań
        questionList = generateQuestions();

        // Wyświetlanie pierwszego pytania
        displayQuestion();

        // Ustawienie akcji po naciśnięciu przycisku "Dalej"
        nextButton.setOnClickListener(v -> {
            // Sprawdzanie, czy użytkownik wybrał odpowiedź
            int selectedId = answersGroup.getCheckedRadioButtonId();
            if (selectedId != -1) { // Jeśli wybrano odpowiedź
                RadioButton selectedRadioButton = findViewById(selectedId);
                int selectedAnswerIndex = answersGroup.indexOfChild(selectedRadioButton);

                // Sprawdzanie poprawności odpowiedzi
                if (selectedAnswerIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                    score += 10; // Dodanie punktów za poprawną odpowiedź
                }

                // Przejście do następnego pytania
                currentQuestionIndex++;

                // Sprawdzanie, czy są jeszcze pytania
                if (currentQuestionIndex < questionList.size()) {
                    displayQuestion(); // Wyświetlenie kolejnego pytania
                } else {
                    showResult(); // Pokazanie wyniku końcowego, jeśli pytania się skończyły
                }
            }
        });
    }

    // Funkcja generująca listę pytań do quizu
    private List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        // Dodawanie przykładowych pytań i odpowiedzi do listy
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

        return questions; // Zwraca listę pytań
    }

    // Funkcja do wyświetlania aktualnego pytania
    private void displayQuestion() {
        // Pobieranie aktualnego pytania z listy
        Question currentQuestion = questionList.get(currentQuestionIndex);
        // Ustawienie tekstu pytania
        questionText.setText(currentQuestion.getQuestion());

        // Wyświetlanie numeru pytania
        questionnumber.setText("Pytanie: " + (currentQuestionIndex + 1) + "/" + questionList.size());

        // Wyświetlanie możliwych odpowiedzi
        for (int i = 0; i < answersGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) answersGroup.getChildAt(i);
            radioButton.setText(currentQuestion.getAnswers()[i]);
        }

        // Ustawienie wartości paska postępu
        progressBar.setProgress((int) ((currentQuestionIndex + 1) / (float) questionList.size() * 100));
        // Wyczyszczenie zaznaczenia odpowiedzi po przejściu do nowego pytania
        answersGroup.clearCheck();
    }

    // Funkcja do wyświetlania wyniku końcowego
    private void showResult() {
        // Wyświetlanie wyniku w TextView
        questionText.setText("Gratulacje! Zdobyłeś " + score + " pkt");
        // Ukrywanie przycisku "Dalej" i grupy odpowiedzi
        nextButton.setVisibility(View.GONE);
        answersGroup.setVisibility(View.GONE);
        // Ukrywanie licznika pytań
        questionnumber.setVisibility(View.GONE);
    }
}
