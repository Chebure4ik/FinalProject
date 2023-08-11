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
    int firstPlayer, secondPlayer, thirdPlayer, fourthPlayer;

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
        secondPlayer = Integer.parseInt(winner.get("point2").toString());
        thirdPlayer = Integer.parseInt(winner.get("point3").toString());
        fourthPlayer = Integer.parseInt(winner.get("point4").toString());

        if(firstPlayer >= 12){
            textView.setText("Победил игрок " + winner.get("name1").toString());
        } else if (secondPlayer >= 12) {
            textView.setText("Победил игрок " + winner.get("name2").toString());
        } else if (thirdPlayer >= 12) {
            textView.setText("Победил игрок " + winner.get("name3").toString());
        } else if (fourthPlayer >= 12) {
            textView.setText("Победил игрок " + winner.get("name4").toString());
        }
    }
}