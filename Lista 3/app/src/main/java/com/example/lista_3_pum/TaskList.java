package com.example.lista_3_pum;

public class TaskList {
    private String subjectName;
    private String grade;
    private int numberOfTasks;

    public TaskList(String subjectName, String grade, int numberOfTasks){
        this.subjectName = subjectName;
        this.grade = grade;
        this.numberOfTasks = numberOfTasks;
    }
    public String getSubjectName() { return subjectName; }
    public String getGrade() { return grade; }
    public int getNumberOfTasks() { return numberOfTasks; }
}
