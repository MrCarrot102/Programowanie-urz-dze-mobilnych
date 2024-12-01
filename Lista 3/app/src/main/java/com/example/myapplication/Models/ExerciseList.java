package com.example.myapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ExerciseList implements Parcelable {

    private final List<Exercise> exercises;
    private final String subject;
    private final float grade;
    private final String name;

    public ExerciseList(List<Exercise> exercises, String subject, float grade, String name) {
        this.exercises = exercises;
        this.subject = subject;
        this.grade = grade;
        this.name = name;
    }

    protected ExerciseList(Parcel in) {
        exercises = in.createTypedArrayList(Exercise.CREATOR);
        subject = in.readString();
        grade = in.readFloat();
        name = in.readString();
    }

    public static final Creator<ExerciseList> CREATOR = new Creator<ExerciseList>() {
        @Override
        public ExerciseList createFromParcel(Parcel in) {
            return new ExerciseList(in);
        }

        @Override
        public ExerciseList[] newArray(int size) {
            return new ExerciseList[size];
        }
    };

    public List<Exercise> getExercises() {
        return exercises;
    }

    public String getSubject() {
        return subject;
    }

    public float getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(exercises);
        dest.writeString(subject);
        dest.writeFloat(grade);
        dest.writeString(name);
    }

}
