package com.example.gymwork;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {
    private GymTraining gymTraining;
    private int minutes;
    private String days;
    private boolean isAccomplished;

    public Plan() {
    }

    public Plan(GymTraining gymTraining, int minutes, String days, boolean isAccomplished) {
        this.gymTraining = gymTraining;
        this.minutes = minutes;
        this.days = days;
        this.isAccomplished = isAccomplished;
    }

    protected Plan(Parcel in) {
        gymTraining = in.readParcelable(GymTraining.class.getClassLoader());
        minutes = in.readInt();
        days = in.readString();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public GymTraining getGymTraining() {
        return gymTraining;
    }

    public void setGymTraining(GymTraining gymTraining) {
        this.gymTraining = gymTraining;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(gymTraining, flags);
        dest.writeInt(minutes);
        dest.writeString(days);
        dest.writeByte((byte) (isAccomplished ? 1 : 0));
    }
}
