package com.example.assignment2_smd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TaskViewModel taskViewModel;
    private TaskListFragment taskListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate"); // Log onCreate
        setContentView(R.layout.activity_main);

        //Init
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        //Load
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
        Log.d(TAG, "Opening Task Input Fragment");
        TaskInputFragment taskInputFragment = TaskInputFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, taskInputFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void addTask(String taskName) {
        Log.d(TAG, "Adding task: " + taskName);
        taskViewModel.addTask(taskName);
        taskListFragment.updateTaskList(); // pass updated list to frag
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult called with requestCode: " + requestCode);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "Result OK received from activity");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
