package com.example.myapplication.Data;

import com.example.myapplication.Models.Subject;
import com.example.myapplication.Models.Exercise;
import com.example.myapplication.Models.ExerciseList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataProvider {

    // Lista przedmiotów
    public static final List<Subject> subjects = Arrays.asList(
            new Subject(
                    "PUM",
                    Arrays.asList(4.5f, 3.4f, 5f),
                    Collections.singletonList(
                            new ExerciseList(
                                    "PUM",
                                    Arrays.asList(
                                            new Exercise("Zadanie 1", "Tresc zadania 1", 4),
                                            new Exercise("Zadanie 2", "Tresc zadania 2", 7)
                                    ),
                                    4f,
                                    "Lista 1"
                            )
                    )
            ),
            new Subject(
                    "Matematyka",
                    Arrays.asList(3.0f, 4.0f, 5.0f),
                    Collections.singletonList(
                            new ExerciseList(
                                    "Matematyka",
                                    Arrays.asList(
                                            new Exercise("Zadanie 1", "Oblicz pole powierzchni", 8),
                                            new Exercise("Zadanie 2", "Rozwiąż równanie kwadratowe", 6)
                                    ),
                                    3f,
                                    "Lista 1"
                            )
                    )
            ),
            new Subject(
                    "Fizyka",
                    Arrays.asList(4.0f, 3.5f, 4.8f),
                    Arrays.asList(
                            new ExerciseList(
                                    "Fizyka",
                                    Arrays.asList(
                                            new Exercise("Zadanie 1", "Oblicz prędkość", 9),
                                            new Exercise("Zadanie 2", "Wyjaśnij zasadę Newtona", 5)
                                    ),
                                    2.5f,
                                    "Lista 1"
                            ),
                            new ExerciseList(
                                    "Fizyka",
                                    Arrays.asList(
                                            new Exercise("Zadanie 1", "Oblicz prędkość", 9),
                                            new Exercise("Zadanie 2", "Wyjaśnij zasadę Newtona", 5)
                                    ),
                                    2.5f,
                                    "Lista 2"
                            ),
                            new ExerciseList(
                                    "Fizyka",
                                    Collections.singletonList(
                                            new Exercise("Zadanie 1", "Oblicz prędkość", 3)
                                    ),
                                    2.5f,
                                    "Lista 3"
                            )
                    )
            ),
            new Subject(
                    "Elektronika",
                    Arrays.asList(3.5f, 4.5f, 4.0f),
                    Collections.singletonList(
                            new ExerciseList(
                                    "Elektronika",
                                    Arrays.asList(
                                            new Exercise("Zadanie 1", "Narysuj układ elektroniczny", 10),
                                            new Exercise("Zadanie 2: ", "Oblicz opór w obwodzie", 6)
                                    ),
                                    3.5f,
                                    "Lista 1"
                            )
                    )
            ),
            new Subject(
                    "Algorytmy",
                    Arrays.asList(4.2f, 3.8f, 4.9f),
                    Collections.singletonList(
                            new ExerciseList(
                                    "Algorytmy",
                                    Arrays.asList(
                                            new Exercise("Zadanie 1", "Napisz algorytm sortowania", 7),
                                            new Exercise("Zadanie 2", "Opisz algorytm DFS", 8)
                                    ),
                                    4.5f,
                                    "Lista 1"
                            )
                    )
            )
    );
}
