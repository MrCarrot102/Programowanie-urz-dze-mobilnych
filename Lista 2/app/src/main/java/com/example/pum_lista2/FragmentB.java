package com.example.pum_lista2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pum_lista2.databinding.FragmentABinding;
import com.example.pum_lista2.databinding.FragmentBBinding;

public class FragmentB extends Fragment {

    private FragmentBBinding binding;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBBinding.inflate(inflater);

        binding.fabB.setOnClickListener(view -> {
            NavDirections action = FragmentBDirections.actionFragmentBToFragmentA();
            Navigation.findNavController(requireView()).navigate(action);
        });

        binding.textView.setText(String.valueOf(
                getArguments() != null ? getArguments().getInt("value") : 0
        ));

        return binding.getRoot();
    }
}