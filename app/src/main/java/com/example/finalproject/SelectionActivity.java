package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    private Button toPlayButton, someFactsButton, statisticsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        toPlayButton = findViewById(R.id.toPlayButton);
        someFactsButton = findViewById(R.id.someFactsButton);
        statisticsButton = findViewById(R.id.statisticsButton);

        toPlayButton.setOnClickListener(listener);
        someFactsButton.setOnClickListener(listener);
        statisticsButton.setOnClickListener(listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.toPlayButton:
                    startActivity(new Intent(SelectionActivity.this, DifficultyActivity.class));
                    break;
                case R.id.someFactsButton:
                    startActivity(new Intent(SelectionActivity.this, FactsActivity.class));
                    break;
                case R.id.statisticsButton:
                    startActivity(new Intent(SelectionActivity.this, StatisticsActivity.class));
                    break;
            }
        }
    };
}
