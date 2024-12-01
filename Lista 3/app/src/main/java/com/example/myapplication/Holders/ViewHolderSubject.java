package com.example.myapplication.Holders;

import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.ItemSubjectBinding;
import com.example.myapplication.Adapter.AdapterSubject.OnSubjectClickListener;
import com.example.myapplication.Models.Subject;

public class ViewHolderSubject extends RecyclerView.ViewHolder {

    private final ItemSubjectBinding binding;
    private final OnSubjectClickListener onSubjectClick;

    // Konstruktor przyjmujący binding i listener
    public ViewHolderSubject(ItemSubjectBinding binding, OnSubjectClickListener onSubjectClick) {
        super(binding.getRoot());
        this.binding = binding;
        this.onSubjectClick = onSubjectClick;

        // Ustawienie nasłuchiwania na kliknięcie elementu
        itemView.setOnClickListener(v -> onSubjectClick.onSubjectClick(binding.getRoot()));
    }

    // Metoda bind do ustawiania danych
    public void bind(Subject subject) {
        binding.setSubject(subject); // Związanie obiektu Subject z widokiem
        binding.executePendingBindings(); // Zastosowanie zmian
    }
}
