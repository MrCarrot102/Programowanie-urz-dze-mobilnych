package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.ItemTaskListBinding;
import com.example.myapplication.Holders.ViewHolderTaskList;
import com.example.myapplication.Models.ExerciseList;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<ViewHolderTaskList> {

    private final List<ExerciseList> tasks;
    private final OnItemClickListener onItemClick;

    // Interfejs dla kliknięcia elementu
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public TaskListAdapter(List<ExerciseList> tasks, OnItemClickListener onItemClick) {
        this.tasks = tasks;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolderTaskList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTaskListBinding binding = ItemTaskListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderTaskList(binding, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTaskList holder, int position) {
        holder.bind(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
