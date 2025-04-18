package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DifficultyActivity extends AppCompatActivity {
    private Button playEasy, playNormal, playHard;
    private ImageButton backButton;
    public int difficulty = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        playEasy = findViewById(R.id.playEasy);
        playNormal = findViewById(R.id.playNormal);
        playHard = findViewById(R.id.playHard);
        backButton = findViewById(R.id.backButton);

        playEasy.setOnClickListener(listener);
        playNormal.setOnClickListener(listener);
        playHard.setOnClickListener(listener);
        backButton.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.playEasy:
                    difficulty = 1;
                    startActivity(new Intent(DifficultyActivity.this,PlayActivity.class));
                    break;
                case R.id.playNormal:
                    difficulty = 2;
                    startActivity(new Intent(DifficultyActivity.this,PlayActivity.class));
                    break;
                case R.id.playHard:
                    difficulty = 3;
                    startActivity(new Intent(DifficultyActivity.this,PlayActivity.class));
                    break;
                case R.id.backButton:
                    startActivity(new Intent(DifficultyActivity.this, SelectionActivity.class));
            }
        }
    };
}