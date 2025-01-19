package com.example.lista_3_pum.Adapter;



import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lista_3_pum.databinding.ItemGradeBinding;
import java.util.List;
import java.util.Map;

public class GradeListAdapter extends RecyclerView.Adapter<GradeListAdapter.GradeViewHolder> {

    private final List<Map.Entry<String, Float>> subjectGrades;

    public GradeListAdapter(Map<String, Float> subjectGrades) {
        this.subjectGrades = List.copyOf(subjectGrades.entrySet());
    }

    @NonNull
    @Override
    public GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGradeBinding binding = ItemGradeBinding.inflate(inflater, parent, false);
        return new GradeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeViewHolder holder, int position) {
        Map.Entry<String, Float> entry = subjectGrades.get(position);
        holder.bind(entry.getKey(), entry.getValue());
    }

    @Override
    public int getItemCount() {
        return subjectGrades.size();
    }

    public static class GradeViewHolder extends RecyclerView.ViewHolder {
        private final ItemGradeBinding binding;

        public GradeViewHolder(ItemGradeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String subjectName, float averageGrade) {
            binding.textViewSubject.setText(subjectName);
            binding.textViewAverageGrade.setText(String.format("Średnia: %.1f", averageGrade));
        }
    }
}
