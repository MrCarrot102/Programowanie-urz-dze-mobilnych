package com.example.lista_3_pum;

public class TaskList {
    private String subjectName;
    private double  grade;
    private int numberOfTasks;
    private int listNumber;

    public TaskList(String subjectName, int list, double grade, int numberOfTasks){
        this.subjectName = subjectName;
        this.grade = grade;
        this.numberOfTasks = numberOfTasks;
        this.listNumber = list;

    }
    public String getSubjectName() { return subjectName; }
    public double getGrade() { return grade; }
    public int getListNumber() { return listNumber; }
    public int getNumberOfTasks() { return numberOfTasks; }

}
