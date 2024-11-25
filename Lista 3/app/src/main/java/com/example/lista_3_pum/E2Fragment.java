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

import java.util.ArrayList;
import java.util.List;

public class E2Fragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e2, container, false);

        // Inicjalizacja RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Pobranie danych
        List<TaskList> taskLists = getTaskLists();

        // Przypisanie adaptera
        adapter = new TaskListAdapter(taskLists);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Funkcja do tworzenia przykładowych danych
    private List<TaskList> getTaskLists() {
        List<TaskList> taskLists = new ArrayList<>();

        // Dodanie przykładowych danych
        taskLists.add(new TaskList("Matematyka", 1, 4.0, 10));
        taskLists.add(new TaskList("Matematyka", 2, 3.5, 8));
        taskLists.add(new TaskList("PUM", 1, 5.0, 12));
        taskLists.add(new TaskList("Fizyka", 1, 4.5, 9));

        return taskLists;
    }
}
