package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentABinding;

import java.util.ArrayList;

public class FragmentA extends Fragment {
    private final ArrayList<String> wordList = new ArrayList<>();
    private FragmentABinding binding;
    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        for (int i = 0; i < 30; i++)
            wordList.add("Word" + i);
        binding = FragmentABinding.inflate(getLayoutInflater());
        binding.recyclerView.setAdapter(new WordListAdapter(wordList));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return binding.getRoot();
    }
}