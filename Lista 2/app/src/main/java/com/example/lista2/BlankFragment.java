package com.example.lista2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lista2.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    public BlankFragment() {
        // Required empty public constructor
    }
    private FragmentBlankBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}

// to co jest tutaj napisac w drugim tez;