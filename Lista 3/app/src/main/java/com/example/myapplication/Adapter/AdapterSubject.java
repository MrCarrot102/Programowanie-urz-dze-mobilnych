package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.ItemSubjectBinding;
import com.example.myapplication.Holders.ViewHolderSubject;
import java.util.List;
import com.example.myapplication.Models.Subject;

public class AdapterSubject extends RecyclerView.Adapter<ViewHolderSubject> {

    private final List<Subject> subjects;
    private final OnSubjectClickListener onSubjectClick;

    // Interfejs dla kliknięcia przedmiotu
    public interface OnSubjectClickListener {
        void onSubjectClick(Subject subject);

        void onSubjectClick(ConstraintLayout root);
    }

    public AdapterSubject(List<Subject> subjects, OnSubjectClickListener onSubjectClick) {
        this.subjects = subjects;
        this.onSubjectClick = onSubjectClick;
    }

    @NonNull
    @Override
    public ViewHolderSubject onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSubjectBinding binding = ItemSubjectBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderSubject(binding, onSubjectClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSubject holder, int position) {
        holder.bind(subjects.get(position));
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
