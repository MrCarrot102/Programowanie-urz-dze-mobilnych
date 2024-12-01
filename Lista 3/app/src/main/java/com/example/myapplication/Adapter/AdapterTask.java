package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.ItemTaskBinding;
import com.example.myapplication.Holders.ViewHolderTask;
import com.example.myapplication.Models.Exercise;  // Zamiast Task, użyj swojej klasy np. Exercise
import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<ViewHolderTask> {

    private final List<Exercise> exercises;  // Zmiana na swoją klasę, np. Exercise
    private final OnTaskClickListener onTaskClick;

    // Interfejs dla kliknięcia zadania
    public interface OnTaskClickListener {
        void onTaskClick(Exercise exercise);  // Zmiana na odpowiedni typ
    }

    public AdapterTask(List<Exercise> exercises, OnTaskClickListener onTaskClick) {  // Zmiana na odpowiednią listę
        this.exercises = exercises;
        this.onTaskClick = onTaskClick;
    }

    @NonNull
    @Override
    public ViewHolderTask onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTaskBinding binding = ItemTaskBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderTask(binding, onTaskClick);  // Przekazywanie listenera
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTask holder, int position) {
        holder.bind(exercises.get(position));  // Zmiana na odpowiednią listę
    }

    @Override
    public int getItemCount() {
        return exercises.size();  // Zmiana na odpowiednią listę
    }
}
