package com.example.myapplication.Holders;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.ExerciseList;
import com.example.myapplication.databinding.ItemTaskListBinding;

public class ViewHolderTaskList extends RecyclerView.ViewHolder {

    private final ItemTaskListBinding binding;

    public ViewHolderTaskList(ItemTaskListBinding binding, final OnItemClickListener onItemClick) {
        super(binding.getRoot());
        this.binding = binding;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(getAdapterPosition());
                }
            }
        });
    }

    public void bind(ExerciseList task) {
        binding.textTaskListSubjectName.setText(task.getSubject());
        binding.textTaskListName.setText("Liczba zadań: " + task.getExercises().size());
        binding.textTaskListGrade.setText("Ocena: " + task.getGrade());
        binding.textTaskListCounter.setText(task.getName());
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
