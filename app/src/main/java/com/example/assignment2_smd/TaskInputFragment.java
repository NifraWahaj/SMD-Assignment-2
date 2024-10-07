package com.example.assignment2_smd;

import android.os.Bundle;
import android.util.Log; // Import Log for logging lifecycle events
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;

public class TaskInputFragment extends Fragment {
    private static final String TAG = "TaskInputFragment"; // Tag for logging
    private EditText editTextTaskName;
    private Button buttonSaveTask;
    private MainActivity mainActivity;

    public static TaskInputFragment newInstance() {
        return new TaskInputFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView"); // Log onCreateView
        View view = inflater.inflate(R.layout.fragment_task_input, container, false);
        editTextTaskName = view.findViewById(R.id.editTextTaskName);
        buttonSaveTask = view.findViewById(R.id.buttonSaveTask);

        // Save button listener
        buttonSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextTaskName.getText().toString();
                if (!taskName.isEmpty()) {
                    mainActivity.addTask(taskName); // Add task to MainActivity
                    getActivity().getSupportFragmentManager().popBackStack(); // Return to TaskListFragment
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach"); // Log onAttach
        mainActivity = (MainActivity) context; // Get reference to MainActivity
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate"); // Log onCreate
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart"); // Log onStart
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume"); // Log onResume
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause"); // Log onPause
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop"); // Log onStop
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView"); // Log onDestroyView
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach"); // Log onDetach
    }
}
