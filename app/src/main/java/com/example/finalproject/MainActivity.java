package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button twoPlayerButton, threePlayerButton, fourPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPlayerButton = findViewById(R.id.twoPlayerButton);
        threePlayerButton = findViewById(R.id.threePlayerButton);
        fourPlayerButton = findViewById(R.id.fourPlayerButton);

        twoPlayerButton.setOnClickListener(listener);
        threePlayerButton.setOnClickListener(listener);
        fourPlayerButton.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.twoPlayerButton:
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                    break;
                case R.id.threePlayerButton:
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                    break;
                case R.id.fourPlayerButton:
                    intent = new Intent(getApplicationContext(), FourthActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}