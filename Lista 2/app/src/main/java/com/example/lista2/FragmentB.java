package com.example.lista2;

import android.view.LayoutInflater;

public class FragmentB {
    private FragmentBBinding binding;

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        binding = FragmentBBinding.inflate(inflater);
        return binding.getRoot();
    }
}
