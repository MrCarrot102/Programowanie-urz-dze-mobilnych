package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.WordViewBinding;

public class WordListViewHolder extends RecyclerView.ViewHolder {
    private final WordViewBinding binding;
    public WordListViewHolder(WordViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String item){
        binding.singleWord.setText(item);
    }
}
