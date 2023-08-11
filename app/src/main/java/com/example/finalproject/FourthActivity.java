package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourthActivity extends AppCompatActivity {
    private EditText nameIn1, nameIn2, nameIn3, nameIn4;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        nameIn1 = findViewById(R.id.nameIn1);
        nameIn2 = findViewById(R.id.nameIn2);
        nameIn3 = findViewById(R.id.nameIn3);
        nameIn4 = findViewById(R.id.nameIn4);
        playButton = findViewById(R.id.playButton);

        playButton.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PlayActivity.class);

            intent.putExtra("nameIn1", nameIn1.getText().toString());
            intent.putExtra("nameIn2", nameIn2.getText().toString());
            intent.putExtra("nameIn3", nameIn3.getText().toString());
            intent.putExtra("nameIn4", nameIn4.getText().toString());

            startActivity(intent);
        }
    };

    public EditText getNameIn1() {
        return nameIn1;
    }

    public void setNameIn1(EditText nameIn1) {
        this.nameIn1 = nameIn1;
    }

    public EditText getNameIn2() {
        return nameIn2;
    }

    public void setNameIn2(EditText nameIn2) {
        this.nameIn2 = nameIn2;
    }

    public EditText getNameIn3() {
        return nameIn3;
    }

    public void setNameIn3(EditText nameIn3) {
        this.nameIn3 = nameIn3;
    }

    public EditText getNameIn4() {
        return nameIn4;
    }

    public void setNameIn4(EditText nameIn4) {
        this.nameIn4 = nameIn4;
    }
}