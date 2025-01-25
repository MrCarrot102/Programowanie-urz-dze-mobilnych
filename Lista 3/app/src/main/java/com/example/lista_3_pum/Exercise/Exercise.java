package com.example.lista_3_pum.Exercise;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable {
    private String content;
    private int points;

    public Exercise(String content, int points) {
        this.content = content;
        this.points = points;
    }

    protected Exercise(Parcel in) {
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

    public String getContent() {
        return content;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeInt(points);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
