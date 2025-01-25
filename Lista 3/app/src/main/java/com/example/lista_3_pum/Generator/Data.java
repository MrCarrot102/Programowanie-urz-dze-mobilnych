package com.example.lista_3_pum.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

    private static final String[] SUBJECTS = {"Matematyka", "PUM", "Fizyka", "Elektronika", "Algorytmy"};
    private static final Random RANDOM = new Random();

    public static List<com.example.lista_3_pum.Exercise.ExerciseList> generateDummyData() {
        List<com.example.lista_3_pum.Exercise.ExerciseList> exerciseLists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            // Użycie własnej klasy Subject
            com.example.lista_3_pum.Exercise.Subject subject = new com.example.lista_3_pum.Exercise.Subject(SUBJECTS[RANDOM.nextInt(SUBJECTS.length)]);
            float grade = 3.0f + (RANDOM.nextInt((int) ((5.0 - 3.0) / 0.5)) * 0.5f);
            List<com.example.lista_3_pum.Exercise.Exercise> exercises = new ArrayList<>();
            int exerciseCount = RANDOM.nextInt(10) + 1;

            for (int j = 0; j < exerciseCount; j++) {
                exercises.add(new com.example.lista_3_pum.Exercise.Exercise("Zrobic zadanie w ksiazce numer " + RANDOM.nextInt(100), RANDOM.nextInt(10) + 1));
            }

            exerciseLists.add(new com.example.lista_3_pum.Exercise.ExerciseList(exercises, subject, grade));
        }
        return exerciseLists;
    }
}
