package com.example.pum_lista2;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

            if (username.isEmpty() || password.isEmpty()) {}
            else {
              // instrukcja usermanager
                UserManager userManager = UserManager.getInstance();

                // sprawdzanie danych uzytkownika
                if (userManager.validateLogin(username, password)) {
                    // jesli jest poprawny login i haslo to przejscie do ostatniego fragmentu
                    NavDirections action = FragmentCDirections.actionFragmentCToFragmentD(username);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        // przycisk odpowiedzialny za rejestrację
        binding.registerButtonInLogin.setOnClickListener(view -> {
            // przejście do fragmentu rejestracji (FragmentB)
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
