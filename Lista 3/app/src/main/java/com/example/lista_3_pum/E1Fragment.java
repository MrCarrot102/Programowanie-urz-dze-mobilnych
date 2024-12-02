package com.example.lista_3_pum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lista_3_pum.Adapter.TaskListAdapter;
import com.example.lista_3_pum.Exercise.ExerciseList;
import com.example.lista_3_pum.Generator.Data;

import java.util.List;

public class E1Fragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskListAdapter adapter;
    private List<ExerciseList> taskLists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e1, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        taskLists = Data.generateDummyData();
        adapter = new TaskListAdapter(taskLists, exerciseList -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("selectedList", exerciseList);
            NavController navController = NavHostFragment.findNavController(E1Fragment.this);
            navController.navigate(R.id.action_fragmentE1_to_fragmentE3, bundle);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }
}
