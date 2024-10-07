package com.example.assignment2_smd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import Log for logging lifecycle events
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity"; // Tag for logging
    private TaskViewModel taskViewModel;
    private TaskListFragment taskListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate"); // Log onCreate
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        // Load the TaskListFragment
        taskListFragment = TaskListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, taskListFragment)
                .commit();

        FloatingActionButton fabReview = findViewById(R.id.fabReview);
        fabReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTaskInputFragment();
            }
        });
    }

    private void openTaskInputFragment() {
        Log.d(TAG, "Opening Task Input Fragment"); // Log fragment opening
        TaskInputFragment taskInputFragment = TaskInputFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, taskInputFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void addTask(String taskName) {
        Log.d(TAG, "Adding task: " + taskName); // Log task addition
        taskViewModel.addTask(taskName);
        taskListFragment.updateTaskList(); // Pass updated list to fragment
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult called with requestCode: " + requestCode); // Log onActivityResult
        if (requestCode == 1) {
            // Handle result if needed
            if (resultCode == RESULT_OK) {
                // Process any data returned from MainActivity if needed
                Log.d(TAG, "Result OK received from activity"); // Log result processing
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart"); // Log onStart
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume"); // Log onResume
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause"); // Log onPause
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop"); // Log onStop
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy"); // Log onDestroy
    }
}
