package com.example.assignment2_smd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import Log for logging lifecycle events
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity"; // Tag for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate"); // Log onCreate
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView logo = findViewById(R.id.imageView); // Your logo ImageView
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logo.startAnimation(animation);

        // Navigate to MainActivity when animation ends
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG, "Animation started"); // Log animation start
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "Animation ended"); // Log animation end
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivityForResult(intent, 1); // Start MainActivity with a request code
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
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
