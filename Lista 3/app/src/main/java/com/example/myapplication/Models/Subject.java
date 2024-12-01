package com.example.myapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Parcelable {

    private final String name;
    private final List<Float> grades;
    private final List<ExerciseList> exercises;

    public Subject(String name, List<Float> grades, List<ExerciseList> exercises) {
        this.name = name;
        this.grades = grades;
        this.exercises = exercises;
    }

    protected Subject(Parcel in) {
        name = in.readString();
        // Manually create a List<Float> from the Parcel
        grades = new ArrayList<>();
        in.readList(grades, Float.class.getClassLoader());  // Read each float and add to the list

        // Read the ExerciseList objects using the CREATOR
        exercises = in.createTypedArrayList(ExerciseList.CREATOR);
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

    public List<Float> getGrades() {
        return grades;
    }

    public List<ExerciseList> getExercises() {
        return exercises;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeList(grades);  // Write the List<Float> to the parcel
        dest.writeTypedList(exercises);  // Write the List<ExerciseList> to the parcel
    }
}
