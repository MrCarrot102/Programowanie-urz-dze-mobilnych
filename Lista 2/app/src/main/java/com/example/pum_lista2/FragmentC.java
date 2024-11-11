package com.example.pum_lista2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.pum_lista2.databinding.FragmentCBinding;

public class FragmentC extends Fragment {

    private FragmentCBinding binding;

    public FragmentC() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCBinding.inflate(inflater, container, false);

        // przycisk do logowania
        binding.loginButton.setOnClickListener(view -> {
            String username = binding.loginUsername.getText().toString();
            String password = binding.loginPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show();
            } else {
                // przejscie do fragmentu D z przekazaniem danych username
                NavDirections action = FragmentCDirections.actionFragmentCToFragmentD(username);
                Navigation.findNavController(view).navigate(action);
            }
        });

        //  przycisk odpowiedziakny za rejestracje
        binding.registerButtonInLogin.setOnClickListener(view -> {
            // przycisk przechodzenia do fragment B rejestracja
            NavDirections action = FragmentCDirections.actionFragmentCToFragmentB();
            Navigation.findNavController(view).navigate(action);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
