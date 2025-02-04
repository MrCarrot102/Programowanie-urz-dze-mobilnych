package com.example.pum_lista2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pum_lista2.databinding.FragmentDBinding;

public class FragmentD extends Fragment {

    private FragmentDBinding binding;

    public FragmentD() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDBinding.inflate(inflater, container, false);

        String username = getArguments().getString("username");
        // wyswietlanie nazwy uzytkownika po zalogowaniu
        binding.welcomeText.setText("Witaj, " + username);

        binding.logoutButton.setOnClickListener(view -> {
            NavDirections action = FragmentDDirections.actionFragmentDToFragmentA();
            Navigation.findNavController(view).navigate(action);
        });

        return binding.getRoot();
    }
}
