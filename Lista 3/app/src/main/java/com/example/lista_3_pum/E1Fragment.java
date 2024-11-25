package com.example.lista_3_pum;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class E1Fragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskListAdapter taskListAdapter;
    private List<TaskList> taskList;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_e1, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Przykładowe dane
        taskList = new ArrayList<>();
        taskList.add(new TaskList("Matematyka", "5", 5));
        taskList.add(new TaskList("Fizyka", "3", 3));
        taskList.add(new TaskList("Chemia", "7", 4));

        // Ustawienie adaptera
        taskListAdapter = new TaskListAdapter(taskList);
        recyclerView.setAdapter(taskListAdapter);

        return rootView;
    }
}
