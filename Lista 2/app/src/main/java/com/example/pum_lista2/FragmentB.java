package com.example.pum_lista2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pum_lista2.databinding.FragmentBBinding;
import android.widget.Toast;

public class FragmentB extends Fragment {

    private FragmentBBinding binding;

    public FragmentB() {
        // Wymagany pusty konstruktor publiczny
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBBinding.inflate(inflater, container, false);

        // przycisk do rejestracji użytkownika
        binding.registerButton.setOnClickListener(view -> {
            String username = binding.registerUsername.getText().toString();
            String password = binding.registerPassword.getText().toString();
            String confirmPassword = binding.registerConfirmPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(getActivity(), "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(getActivity(), "Hasła nie pasują", Toast.LENGTH_SHORT).show();
            } else {
                // Pobranie instancji UserManager i dodanie nowego użytkownika
                UserManager userManager = UserManager.getInstance(); // założenie, że UserManager jest singletonem

                boolean isAdded = userManager.addUser(username, password);
                if (isAdded) {
                    Toast.makeText(getActivity(), "Rejestracja zakończona sukcesem!", Toast.LENGTH_SHORT).show();
                    // Przejście do ekranu logowania
                    NavDirections action = FragmentBDirections.actionFragmentBToFragmentC();
                    Navigation.findNavController(view).navigate(action);
                } else {
                    // Jeśli użytkownik o takiej nazwie już istnieje
                    Toast.makeText(getActivity(), "Użytkownik już istnieje!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
