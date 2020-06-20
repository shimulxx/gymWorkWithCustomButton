package com.example.gymwork;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlanRecViewAdapter extends RecyclerView.Adapter<PlanRecViewAdapter.ViewHolder>{
    private static final String TAG = "PlanRecViewAdapter";
    private Context context;
    private ArrayList<Plan> plans = new ArrayList<>();
    private String type = "";

    public interface Deleteplan{
        void onDeletingPlan(String day);
    }

    private Deleteplan deleteplan;

    public PlanRecViewAdapter() {
    }

    public PlanRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: started");
        holder.activityName.setText(plans.get(position).getGymTraining().getName());
        Glide.with(context)
                .asBitmap()
                .load(plans.get(position).getGymTraining().getImageUrl())
                .into(holder.activityImage);
        holder.activityTime.setText(String.valueOf(plans.get(position).getMinutes()));
        holder.activityShortDescription.setText(String.valueOf(plans.get(position).getGymTraining().getShortDesc()));
        if(plans.get(position).isAccomplished()){
            holder.emptyCheckBox.setVisibility(View.GONE);
            holder.filledCheckBox.setVisibility(View.VISIBLE);
        }else{
            holder.emptyCheckBox.setVisibility(View.VISIBLE);
            holder.filledCheckBox.setVisibility(View.GONE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TrainingActivity.class);
                intent.putExtra("training", plans.get(position).getGymTraining());
                context.startActivity(intent);
            }
        });

        if(type.equals("edit")){
            holder.emptyCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Accomplished?")
                            .setMessage("Have you finished " + plans.get(position).getGymTraining().getName())
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    plans.get(position).setAccomplished(true);
                                    for(Plan plan: Utilities.getUsersPlan()){
                                        if(plan.equals(plans.get(position)))
                                            plan.setAccomplished(true);
                                    }
                                    notifyDataSetChanged();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
            });

            try{
                deleteplan = (Deleteplan) context;
            }catch (Exception e){
                e.printStackTrace();
            }

            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Delete")
                            .setMessage("Are you sure you want to delete " + plans.get(position).getGymTraining().getName() + " " +
                                    "from your weekly plans?")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Utilities.removeUsersPlan(plans.get(position));
                                    deleteplan.onDeletingPlan(plans.get(position).getDays());
                                    //notifyDataSetChanged();
                                }
                            });
                    builder.create().show();
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView activityName, activityTime, activityShortDescription;
        private ImageView activityImage, emptyCheckBox, filledCheckBox;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            activityName = (TextView)itemView.findViewById(R.id.activityName);
            activityTime = (TextView)itemView.findViewById(R.id.textTimeAmount);
            activityShortDescription = (TextView)itemView.findViewById(R.id.textShortDescription);
            parent = (CardView)itemView.findViewById(R.id.parent2);
            activityImage = (ImageView)itemView.findViewById(R.id.activityImage);
            emptyCheckBox = (ImageView)itemView.findViewById(R.id.emptyCheckBox);
            filledCheckBox = (ImageView)itemView.findViewById(R.id.filledCheckBox);
        }
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
