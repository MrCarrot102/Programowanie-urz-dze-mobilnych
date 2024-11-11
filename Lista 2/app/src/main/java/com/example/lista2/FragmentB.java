package com.example.lista2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lista2.databinding.FragmentBlankBinding;


public class FragmentB extends Fragment {
    public FragmentB() {
        // Required empty public constructor
    }
    private FragmentB binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentB.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}