package com.example.gymwork;

import android.os.Parcel;
import android.os.Parcelable;

public class GymTraining implements Parcelable {
    private int id;
    private String name;
    private String shortDesc;
    private String longDesc;
    private String imageUrl;

    public GymTraining() {

    }

    public GymTraining(int id, String name, String shortDesc, String longDesc, String imageUrl) {
        this.id = id;
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.imageUrl = imageUrl;
    }

    protected GymTraining(Parcel in) {
        id = in.readInt();
        name = in.readString();
        shortDesc = in.readString();
        longDesc = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(shortDesc);
        dest.writeString(longDesc);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GymTraining> CREATOR = new Creator<GymTraining>() {
        @Override
        public GymTraining createFromParcel(Parcel in) {
            return new GymTraining(in);
        }

        @Override
        public GymTraining[] newArray(int size) {
            return new GymTraining[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "GymTraining{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
