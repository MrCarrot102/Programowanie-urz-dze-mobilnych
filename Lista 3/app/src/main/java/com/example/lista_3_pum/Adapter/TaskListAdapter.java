package com.example.lista_3_pum.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lista_3_pum.Exercise.ExerciseList;
import com.example.lista_3_pum.databinding.ItemTaskBinding;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    private final List<ExerciseList> data;
    private final OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ExerciseList exerciseList);
    }

    public TaskListAdapter(List<ExerciseList> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTaskBinding binding = ItemTaskBinding.inflate(inflater, parent, false);
        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        ExerciseList exerciseList = data.get(position);
        holder.bind(exerciseList);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private final ItemTaskBinding binding;

        public TaskViewHolder(ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ExerciseList exerciseList) {
            binding.textViewSubject.setText(exerciseList.getSubject().getName());
            binding.textViewGrade.setText(String.format("Ocena: %.1f", exerciseList.getGrade()));
            binding.textViewTaskCount.setText("Liczba zadań: " + exerciseList.getExercises().size());
            binding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(exerciseList));
        }
    }
}
