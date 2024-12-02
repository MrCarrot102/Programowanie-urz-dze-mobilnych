package com.example.lista_3_pum.Exercise;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ExerciseList implements Parcelable {
    private List<Exercise> exercises;
    private Subject subject;
    private float grade;

    public ExerciseList(List<Exercise> exercises, Subject subject, float grade) {
        this.exercises = exercises;
        this.subject = subject;
        this.grade = grade;
    }

    protected ExerciseList(Parcel in) {
        exercises = in.createTypedArrayList(Exercise.CREATOR);
        subject = in.readParcelable(Subject.class.getClassLoader());
        grade = in.readFloat();
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

    public Subject getSubject() {
        return subject;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(exercises);
        dest.writeParcelable(subject, flags);
        dest.writeFloat(grade);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
