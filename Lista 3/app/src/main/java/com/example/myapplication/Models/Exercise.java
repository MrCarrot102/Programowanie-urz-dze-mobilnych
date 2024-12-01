package com.example.myapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable {

    private final String name;
    private final String content;
    private final int points;

    public Exercise(String name, String content, int points) {
        this.name = name;
        this.content = content;
        this.points = points;
    }

    protected Exercise(Parcel in) {
        name = in.readString();
        content = in.readString();
        points = in.readInt();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(content);
        dest.writeInt(points);
    }

}
