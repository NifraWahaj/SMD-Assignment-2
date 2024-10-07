package com.example.assignment2_smd;

import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "TaskInputFragment";
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

        buttonSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextTaskName.getText().toString();
                if (!taskName.isEmpty()) {
                    mainActivity.addTask(taskName); // Add task to MainActivity
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        mainActivity = (MainActivity) context;
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
