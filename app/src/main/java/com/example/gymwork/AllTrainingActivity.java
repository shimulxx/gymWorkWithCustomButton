package com.example.gymwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AllTrainingActivity extends AppCompatActivity {

    private static final String TAG = "AllTrainingActivity";

    private RecyclerView recyclerView;
    private TrainingRecViewAdapter trainingRecViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_training);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        trainingRecViewAdapter = new TrainingRecViewAdapter(this);
        recyclerView.setAdapter(trainingRecViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        trainingRecViewAdapter.setTrainings(Utilities.getTrainings());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AllTrainingActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
