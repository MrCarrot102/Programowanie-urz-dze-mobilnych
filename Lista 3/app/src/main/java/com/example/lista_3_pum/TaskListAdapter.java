package com.example.lista_3_pum;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder> {
    private List<TaskList> taskList;

    public TaskListAdapter(List<TaskList> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_list, parent, false);
        return new TaskListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TaskList task = taskList.get(position);
        holder.subjectNameTextView.setText(task.getSubjectName());
        holder.gradeTextView.setText("Ocena: " + task.getGrade());
        holder.numberOfTasksTextView.setText("Liczba zadań: " + task.getNumberOfTasks());
        holder.listNameTextView.setText("Lista " + task.getListNumber());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskListViewHolder extends RecyclerView.ViewHolder {
        TextView subjectNameTextView, gradeTextView, numberOfTasksTextView, listNameTextView;

        public TaskListViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectNameTextView = itemView.findViewById(R.id.subjectNameTextView);
            gradeTextView = itemView.findViewById(R.id.gradeTextView);
            numberOfTasksTextView = itemView.findViewById(R.id.numberOfTasksTextView);
            listNameTextView = itemView.findViewById(R.id.listNameTextView);
        }
    }
}

