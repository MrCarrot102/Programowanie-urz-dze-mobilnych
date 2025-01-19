package com.example.lista_3_pum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lista_3_pum.Adapter.GradeListAdapter;
import com.example.lista_3_pum.Exercise.ExerciseList;
import com.example.lista_3_pum.Generator.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e2, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Generate dummy data
        List<ExerciseList> exerciseLists = Data.generateDummyData();

        // Calculate averages
        Map<String, Float> subjectAverages = calculateAverageGrades(exerciseLists);

        // Set adapter
        GradeListAdapter adapter = new GradeListAdapter(subjectAverages);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private Map<String, Float> calculateAverageGrades(List<ExerciseList> exerciseLists) {
        Map<String, Float> subjectAverages = new HashMap<>();
        Map<String, Integer> subjectCounts = new HashMap<>();

        for (ExerciseList list : exerciseLists) {
            String subjectName = list.getSubject().getName();
            float grade = list.getGrade();

            // Dodaj ocenę do istniejącego przedmiotu lub inicjalizuj
            subjectAverages.put(subjectName, subjectAverages.getOrDefault(subjectName, 0f) + grade);
            subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
        }

        for (Map.Entry<String, Float> entry : subjectAverages.entrySet()) {
            String subject = entry.getKey();
            float totalGrade = entry.getValue() != null ? entry.getValue() : 0f; // Zabezpieczenie przed null
            int count = subjectCounts.getOrDefault(subject, 0); // Bezpieczne uzyskanie liczby przedmiotów

            if (count > 0) {
                subjectAverages.put(subject, totalGrade / count); // Oblicz średnią tylko, jeśli count > 0
            }
        }

        return subjectAverages;
    }
}
