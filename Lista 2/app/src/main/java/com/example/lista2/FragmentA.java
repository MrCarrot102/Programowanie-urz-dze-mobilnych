package com.example.lista2;

import com.example.lista2.databinding.FragmentABinding;

public class FragmentA extends Fragment{
    private FragmentABinding binding;

    @Override
    public View onCreateViwe(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentABinding.inflate(inflater);
        return binding.getRoot();
    }
}
