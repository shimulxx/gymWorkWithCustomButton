package com.example.gymwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btnSeePlan, btnActivities, btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utilities.initTrainig();

        initViews();
        setOnclickListner();
    }
    private void initViews(){
        btnSeePlan = (Button) findViewById(R.id.btnSeeYourPlan);
        btnActivities = (Button)findViewById(R.id.btnSeeAllActivities);
        btnAbout = (Button)findViewById(R.id.btnAboutUs);
    }

    private void setOnclickListner(){
        Log.d(TAG, "setOnclickListner: started");
        btnActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingActivity.class);
                startActivity(intent);
            }
        });

        btnSeePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAbout dialogAbout = new DialogAbout();
                dialogAbout.show(getSupportFragmentManager(), "about tag");
            }
        });
    }
}
