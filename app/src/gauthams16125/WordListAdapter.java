package com.example.gauthams16125;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public final LinkedList<String> mWordList;

    WordListAdapter(Context context, LinkedList<String> wordList) {
        this.mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final WordListAdapter mAdapter;
        public final TextView wordItemView;

        WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            this.wordItemView = (TextView) itemView.findViewById(C0370R.C0372id.word);
            this.mAdapter = adapter;
        }

        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            WordListAdapter.this.mWordList.set(mPosition, (String) WordListAdapter.this.mWordList.get(mPosition));
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @NonNull
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordViewHolder(this.mInflater.inflate(C0370R.layout.wordlist_item, parent, false), this);
    }

    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.wordItemView.setText(this.mWordList.get(position));
    }

    public int getItemCount() {
        return this.mWordList.size();
    }
}
