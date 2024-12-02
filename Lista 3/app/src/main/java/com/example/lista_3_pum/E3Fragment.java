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

import com.example.lista_3_pum.Adapter.TaskAdapter;
import com.example.lista_3_pum.Exercise.Exercise;
import com.example.lista_3_pum.Exercise.ExerciseList;

import java.util.List;



public class E3Fragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private ExerciseList selectedList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e3, container, false);

        // Odbiór przekazanego obiektu
        if (getArguments() != null) {
            selectedList = getArguments().getParcelable("selectedList");
        }

        // Ustawienie RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        if (selectedList != null) {
            List<Exercise> exercises = selectedList.getExercises();
            adapter = new TaskAdapter(exercises);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
