package com.example.lista_3_pum;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sprawdź, czy fragment już został dodany
        if (savedInstanceState == null) {
            // Dodaj TaskListFragment do kontenera
            E1Fragment taskListFragment = new E1Fragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, taskListFragment);
            transaction.commit();
        }
    }
}
