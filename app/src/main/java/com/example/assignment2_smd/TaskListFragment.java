package com.example.assignment2_smd;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;

public class TaskListFragment extends Fragment {
    private static final String TAG = "TaskListFragment";
    private ListView listView;
    private ArrayAdapter<TaskItem> adapter;
    private TaskViewModel taskViewModel;

    public static class TaskItem {
        String taskName;
        boolean isCompleted;

        TaskItem(String taskName) {
            this.taskName = taskName;
            this.isCompleted = false;
        }

        // Override the toString() method
        @Override
        public String toString() {
            return taskName;
        }
    }

    public static TaskListFragment newInstance() {
        return new TaskListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView"); // Log onCreateView
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        listView = view.findViewById(R.id.listView);

        // Init
        taskViewModel = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        // Init adapter with task items - ViewModel
        adapter = new ArrayAdapter<TaskItem>(getContext(), android.R.layout.simple_list_item_multiple_choice, taskViewModel.getTasksList()) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view;
                // strikethrough if completed
                if (taskViewModel.getTasksList().get(position).isCompleted) {
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    textView.setPaintFlags(textView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
                return view;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view1, position, id) -> {
            taskViewModel.getTasksList().get(position).isCompleted = !taskViewModel.getTasksList().get(position).isCompleted; // Toggle completed state
            adapter.notifyDataSetChanged(); // Update UI
            return true; // Indicate event is consumed
        });

        updateTaskList();
        return view;
    }

    public void updateTaskList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
