package com.example.lista_3_pum.Exercise;

import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable {
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    protected Subject(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    public String getName() {
        return name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
