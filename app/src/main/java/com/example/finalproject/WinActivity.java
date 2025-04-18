package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    TextView textView;
    Button buttonExit, buttonRestart;
    int firstPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        textView = findViewById(R.id.textView);
        buttonExit = findViewById(R.id.buttonExit);
        buttonRestart = findViewById(R.id.buttonRestart);

        buttonExit.setOnClickListener(listener);
        buttonRestart.setOnClickListener(listener);

       winnerOut();
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.buttonExit:
                    finish();
                    break;
                case R.id.buttonRestart:
                    Intent intent = new Intent(getApplicationContext(), SelectionActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    public void winnerOut(){
        Bundle winner = getIntent().getExtras();

        firstPlayer = Integer.parseInt(winner.get("point1").toString());
        textView.setText("🏆Количество правильных ответов: "+ firstPlayer);
    }
}