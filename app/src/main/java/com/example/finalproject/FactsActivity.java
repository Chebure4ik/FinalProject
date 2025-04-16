package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactsActivity extends AppCompatActivity {

    private TextView factsView;
    private ImageButton nextButton, prevButton, backButton;
    private String[]facts = {"Югра — историческое название Ханты-Мансийского автономного округа","крупнейший нефтегазоносный регион России","родина коренных народов ханты и манси","здесь протекают реки Обь и Иртыш","расположена на Западно-Сибирской равнине","суровый климат с долгими зимами","столица — Ханты-Мансийск","богата природными заповедниками","сохраняет традиции оленеводства и рыболовства","место проведения фестиваля «Дух огня»","добывает более 50% российской нефти","уникальная экосистема с тайгой и болотами" ,"здесь найдены древние городища и археологические артефакты"};
    private int randomNumber;
    private int a = -1;
    private List<Integer> prevFacts = new ArrayList<>();
    final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        factsView = findViewById(R.id.factsView);
        factsView.setText(facts[random.nextInt(12)]);
        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);
        backButton = findViewById(R.id.backButton);

        nextButton.setOnClickListener(listener);
        prevButton.setOnClickListener(listener);
        backButton.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.nextButton:
                    a = a + 1;
                    randomNumber = random.nextInt(12);
                    prevFacts.add(randomNumber);
                    factsView.setText(facts[prevFacts.get(a)]);
                    break;
                case R.id.prevButton:
                    if (a > 0) {
                    factsView.setText(facts[prevFacts.get(a-1)]);
                    a = a - 1;
                    } else {
                        factsView.setText("Нет предыдущего факта");
                        a = -1;
                    }
                    break;
                case R.id.backButton:
                    startActivity(new Intent(FactsActivity.this, SelectionActivity.class));
                    break;
            }
        }
    };
}