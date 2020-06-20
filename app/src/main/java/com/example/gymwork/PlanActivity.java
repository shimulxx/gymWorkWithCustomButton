package com.example.gymwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    private static final String TAG = "PlanActivity";

    private RecyclerView satRec,sunRec,monRec,tuesRec,wedRes,thursRec,friRec;
    private RelativeLayout notAddedAPlanRelLayout;
    private Button btnAddAPlan;
    private NestedScrollView nestedScrollView;
    private TextView satEdit, sunEdit, monEdit, tuesEdit, wedEdit, thurEdit, friEdit;

    private PlanRecViewAdapter satAdapter, sunAdapter, monAdapter, tuesAdapter, wedAdapter, thursAdapter, friAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        initViews();
        initAdapter();
        attachRecViewsWithAdapter();

        if(Utilities.getUsersPlan().size() > 0){
            notAddedAPlanRelLayout.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }else{
            notAddedAPlanRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
        }
        setOnclickListner();
    }

    private void setOnclickListner(){
        Log.d(TAG, "setOnclickListner: started");
        satEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Saturday");
                startActivity(intent);
            }
        });
        sunEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Sunday");
                startActivity(intent);
            }
        });
        monEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Monday");
                startActivity(intent);
            }
        });
        tuesEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Tuesday");
                startActivity(intent);
            }
        });
        wedEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Wednesday");
                startActivity(intent);
            }
        });
        thurEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Thursday");
                startActivity(intent);
            }
        });
        friEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day","Friday");
                startActivity(intent);
            }
        });
        btnAddAPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    private void attachRecViewsWithAdapter(){
        Log.d(TAG, "initRecViewsAdapter: started");

        satRec.setAdapter(satAdapter);
        satRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> saturdayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Saturday")){
                saturdayPlans.add(plan);
            }
        }
        satAdapter.setPlans(saturdayPlans);

        sunRec.setAdapter(sunAdapter);
        sunRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> sundayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Sunday")){
                sundayPlans.add(plan);
            }
        }
        sunAdapter.setPlans(sundayPlans);

        monRec.setAdapter(monAdapter);
        monRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> mondayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Monday")){
                mondayPlans.add(plan);
            }
        }
        monAdapter.setPlans(mondayPlans);

        tuesRec.setAdapter(tuesAdapter);
        tuesRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> tuesdayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Tuesday")){
                tuesdayPlans.add(plan);
            }
        }
        tuesAdapter.setPlans(tuesdayPlans);

        wedRes.setAdapter(wedAdapter);
        wedRes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> wednesdayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Wednesday")){
                wednesdayPlans.add(plan);
            }
        }
        wedAdapter.setPlans(wednesdayPlans);

        thursRec.setAdapter(thursAdapter);
        thursRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> thursdayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Thursday")){
                thursdayPlans.add(plan);
            }
        }
        thursAdapter.setPlans(thursdayPlans);

        friRec.setAdapter(friAdapter);
        friRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Plan> fridayPlans = new ArrayList<>();
        for(Plan plan: Utilities.getUsersPlan()){
            if(plan.getDays().equals("Friday")){
                fridayPlans.add(plan);
            }
        }
        friAdapter.setPlans(fridayPlans);
    }

    private void initAdapter(){
        satAdapter = new PlanRecViewAdapter(this);
        sunAdapter = new PlanRecViewAdapter(this);
        monAdapter = new PlanRecViewAdapter(this);
        tuesAdapter = new PlanRecViewAdapter(this);
        wedAdapter = new PlanRecViewAdapter(this);
        thursAdapter = new PlanRecViewAdapter(this);
        friAdapter = new PlanRecViewAdapter(this);
    }

    private void initViews(){
        Log.d(TAG, "initViews: started");
        satRec = (RecyclerView)findViewById(R.id.saturDayRecView);
        sunRec = (RecyclerView)findViewById(R.id.sunDayRecView);
        monRec = (RecyclerView)findViewById(R.id.monDayRecView);
        tuesRec = (RecyclerView)findViewById(R.id.tuesDayRecView);
        wedRes = (RecyclerView)findViewById(R.id.wedDayRecView);
        thursRec = (RecyclerView)findViewById(R.id.thursDayRecView);
        friRec = (RecyclerView)findViewById(R.id.friDayRecView);

        notAddedAPlanRelLayout = (RelativeLayout)findViewById(R.id.notAddedAPlanRelLayout);
        btnAddAPlan = (Button)findViewById(R.id.btnAddAplan);
        nestedScrollView = (NestedScrollView)findViewById(R.id.nestedScrollView);

        satEdit = (TextView)findViewById(R.id.editSaturdayPlan);
        sunEdit = (TextView)findViewById(R.id.editSundayPlan);
        monEdit = (TextView)findViewById(R.id.editMondayPlan);
        tuesEdit = (TextView)findViewById(R.id.editTuesDayPlan);
        wedEdit = (TextView)findViewById(R.id.editWednesDayPlan);
        thurEdit = (TextView)findViewById(R.id.editThursDayPlan);
        friEdit = (TextView)findViewById(R.id.editFridayPlan);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        super.onBackPressed();
    }
}
