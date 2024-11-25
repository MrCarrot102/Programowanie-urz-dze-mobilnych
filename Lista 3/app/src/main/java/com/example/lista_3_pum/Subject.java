package com.example.lista_3_pum;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<TaskList> taskLists;

    public Subject(String name) {
        this.name = name;
        this.taskLists = new ArrayList<>();
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public double calculateAverageGrade() {
        if (taskLists.isEmpty()) return 0.0;

        double totalGrade = 0;
        for (TaskList taskList : taskLists) {
            totalGrade += taskList.getGrade();
        }
        return totalGrade / taskLists.size();
    }

    public String getName() {
        return name;
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }
}
