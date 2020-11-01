package com.example.gauthams16125;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.LinkedList;

public class History extends AppCompatActivity {
    /* access modifiers changed from: private */
    public WordListAdapter mAdapter;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public LinkedList<String> mWordList = new LinkedList<>();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0370R.layout.activity_history);
        setSupportActionBar((Toolbar) findViewById(C0370R.C0372id.toolbar));
        ((FloatingActionButton) findViewById(C0370R.C0372id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.WordList.clear();
                History.this.mWordList.clear();
                History history = History.this;
                RecyclerView unused = history.mRecyclerView = (RecyclerView) history.findViewById(C0370R.C0372id.recyclerview);
                History history2 = History.this;
                WordListAdapter unused2 = history2.mAdapter = new WordListAdapter(history2, history2.mWordList);
                History.this.mRecyclerView.setAdapter(History.this.mAdapter);
                History.this.mRecyclerView.setLayoutManager(new LinearLayoutManager(History.this));
                Toast.makeText(History.this, "History Cleared", 1).show();
                Toast.makeText(History.this.getApplicationContext(), "Deleted successfully!", 0).show();
                MainActivity.f41l = 0;
            }
        });
        this.mWordList = MainActivity.WordList;
        this.mRecyclerView = (RecyclerView) findViewById(C0370R.C0372id.recyclerview);
        this.mAdapter = new WordListAdapter(this, this.mWordList);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
