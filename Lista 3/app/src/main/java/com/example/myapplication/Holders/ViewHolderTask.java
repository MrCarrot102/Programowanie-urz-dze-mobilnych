package com.example.myapplication.Holders;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Exercise;
import com.example.myapplication.databinding.ItemTaskBinding;
import com.example.myapplication.Adapter.AdapterTask.OnTaskClickListener;

public class ViewHolderTask extends RecyclerView.ViewHolder {

    private final ItemTaskBinding binding;
    private final OnTaskClickListener onTaskClick;

    // Konstruktor przyjmujący binding i listener
    public ViewHolderTask(ItemTaskBinding binding, OnTaskClickListener onTaskClick) {
        super(binding.getRoot());
        this.binding = binding;
        this.onTaskClick = onTaskClick;

        // Ustawienie nasłuchiwania na kliknięcie elementu
        itemView.setOnClickListener(v -> onTaskClick.onTaskClick(binding.getExercise()));
    }

    // Metoda bind do ustawiania danych
    public void bind(Exercise exercise) {  // Przekaż obiekt Exercise (lub inny, który masz)
        binding.setExercise(exercise); // Związanie obiektu Exercise z widokiem
        binding.executePendingBindings(); // Zastosowanie zmian
    }
}
