package com.example.gymwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecViewAdapter.Deleteplan{

    private static final String TAG = "EditActivity";

    private RecyclerView recyclerView;
    private TextView textDay;
    private Button buttonAddMorePlan;

    private PlanRecViewAdapter planRecViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initViews();
        planRecViewAdapter = new PlanRecViewAdapter(this);
        planRecViewAdapter.setType("edit");
        recyclerView.setAdapter(planRecViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        try{
            String day = intent.getStringExtra("day");
            textDay.setText(day);
            ArrayList<Plan> plans = new ArrayList<>();
            for(Plan plan: Utilities.getUsersPlan()){
                if(plan.getDays().equals(day))
                    plans.add(plan);
            }
            planRecViewAdapter.setPlans(plans);
        }catch (Exception e){
            e.printStackTrace();
        }
        buttonAddMorePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        Log.d(TAG, "initViews: started");
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView9);
        textDay = (TextView)findViewById(R.id.textDay9);
        buttonAddMorePlan = (Button)findViewById(R.id.buttonAddmorePlans9);
    }

    @Override
    public void onDeletingPlan(String day) {
        Log.d(TAG, "onDeletingPlan: started");
        textDay.setText(day);
        ArrayList<Plan> plans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals(day))
                plans.add(plan);
        }
        planRecViewAdapter.setPlans(plans);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
