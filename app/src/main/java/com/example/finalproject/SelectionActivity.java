package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SelectionActivity extends AppCompatActivity {

    private Button toPlayButton, someFactsButton, statisticsButton;
    private ImageButton buttonLeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        toPlayButton = findViewById(R.id.toPlayButton);
        someFactsButton = findViewById(R.id.someFactsButton);
        statisticsButton = findViewById(R.id.statisticsButton);
        buttonLeave = findViewById(R.id.buttonLeave);

        toPlayButton.setOnClickListener(listener);
        someFactsButton.setOnClickListener(listener);
        statisticsButton.setOnClickListener(listener);
        buttonLeave.setOnClickListener(listener);

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
                case R.id.buttonLeave:
                    Intent i = new Intent(Intent.ACTION_MAIN);
                    i.addCategory(Intent.CATEGORY_HOME);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    break;
            }
        }
    };
}
