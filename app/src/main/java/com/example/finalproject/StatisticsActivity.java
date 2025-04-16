package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class StatisticsActivity extends AppCompatActivity {
    private EditText nameIn1, nameIn2, nameIn3, nameIn4;
    private Button playButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(StatisticsActivity.this,SelectionActivity.class));
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