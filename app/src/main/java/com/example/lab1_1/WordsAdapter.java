package com.example.lab1_1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {

    private final List<Words> wordsList;

    public WordsAdapter(List<Words> wordsList) {
        this.wordsList = wordsList;
    }

    @NonNull
    @Override
    public WordsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsAdapter.ViewHolder holder, int position) {
        holder.text.setText(wordsList.get(position).word);
    }

    @Override
    public int getItemCount() {
        return wordsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
