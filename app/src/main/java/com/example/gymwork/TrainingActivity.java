package com.example.gymwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements AskforDetailsDialog.GetDetails {

    private static final String TAG = "TrainingActivity";

    private Button btnAddtoPLan;
    private TextView trainingName, trainingLongDesc;
    private ImageView trainingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        initViews();
        Intent intent = getIntent();
        try{
            final GymTraining incommingGymTrainig = intent.getParcelableExtra("training");
            trainingName.setText(incommingGymTrainig.getName());
            trainingLongDesc.setText(incommingGymTrainig.getLongDesc());
            Glide.with(this)
                    .asBitmap()
                    .load(incommingGymTrainig.getImageUrl())
                    .into(trainingImage);
            btnAddtoPLan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO:pending
                    AskforDetailsDialog askforDetailsDialog = new AskforDetailsDialog();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("training", incommingGymTrainig);
                    askforDetailsDialog.setArguments(bundle);
                    askforDetailsDialog.show(getSupportFragmentManager(), "Ask for details");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initViews(){
        Log.d(TAG, "initViews: started");
        btnAddtoPLan = (Button)findViewById(R.id.btnAddtoPlan);
        trainingName = (TextView)findViewById(R.id.trainigName2);
        trainingLongDesc = (TextView)findViewById(R.id.trainigLongDesc);
        trainingImage = (ImageView)findViewById(R.id.trainigImage);
    }

    @Override
    public void onGettingDetailsResult(Plan plan) {
        Log.d(TAG, "onGettingDetailsResult: we have a plan");
        Utilities.addToUsersPlan(plan);
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("plan", plan);
        startActivity(intent);
    }
}
