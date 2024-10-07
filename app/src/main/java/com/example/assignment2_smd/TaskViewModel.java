package com.example.assignment2_smd;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class TaskViewModel extends ViewModel {
    private final ArrayList<TaskListFragment.TaskItem> tasksList = new ArrayList<>();

    public ArrayList<TaskListFragment.TaskItem> getTasksList() {
        return tasksList;
    }

    public void addTask(String taskName) {
        tasksList.add(new TaskListFragment.TaskItem(taskName));
    }
}
