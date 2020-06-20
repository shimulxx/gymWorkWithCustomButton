package com.example.gymwork;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class AskforDetailsDialog extends DialogFragment {
    private static final String TAG = "AskforDetailsDialog";

    private EditText timeEditText;
    private Button btnAdd, btnCancel;
    private Spinner spinnerDay;

    public interface GetDetails {
        void onGettingDetailsResult(Plan plan);
    }

    private GetDetails getDetails;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_ask_for_details, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Enter Details")
                .setView(view);

        initViews(view);

        ArrayList<String> days = new ArrayList<>();
        days.add("Saturday");
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, days);
        spinnerDay.setAdapter(adapter);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        try{
            getDetails = (GetDetails) getActivity();
        }catch (Exception e){
            e.printStackTrace();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Bundle bundle = getArguments();
               GymTraining incommingGymTraing = bundle.getParcelable("training");
               if(incommingGymTraing != null){
                   Plan plan = new Plan();
                   plan.setAccomplished(false);
                   plan.setDays(spinnerDay.getSelectedItem().toString());
                   plan.setMinutes(Integer.parseInt(timeEditText.getText().toString()));
                   plan.setGymTraining(incommingGymTraing);
                   getDetails.onGettingDetailsResult(plan);
               }

           }
       });

        return builder.create();
    }
    private void initViews(View view){
        Log.d(TAG, "initViews: started");
        timeEditText = (EditText)view.findViewById(R.id.editTextTime);
        btnAdd = (Button)view.findViewById(R.id.btnAdd);
        btnCancel = (Button)view.findViewById(R.id.btnCancel);
        spinnerDay = (Spinner)view.findViewById(R.id.spinnerDay);
    }

    @Override
    public int show(@NonNull FragmentTransaction transaction, @Nullable String tag) {
        return super.show(transaction, tag);
    }
}
