package com.example.santiago_aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class AnimationStart extends AppCompatActivity {

    Button btnVolveralMain2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_start);
        btnVolveralMain2 = findViewById(R.id.btnVolveralMain2);

        btnVolveralMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AnimationStart.this, MainActivity.class);
                startActivity(intent);

            }
        }
        );
    }
}