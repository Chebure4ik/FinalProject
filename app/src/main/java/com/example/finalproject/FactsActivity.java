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
    private String[]facts = {"Югра — историческое название Ханты-Мансийского автономного округа","Крупнейший нефтегазоносный регион России","Родина коренных народов ханты и манси","Более 30 тыс. рек и 290 тыс. озер, включая крупные — Обь и Иртыш.","расположена на Западно-Сибирской равнине","Суровый климат с долгими зимами","Столица — Ханты-Мансийск, известный биатлонным центром мирового уровня.","Сохраняет традиции оленеводства и рыболовства","Место проведения фестиваля «Дух огня»","Югра (ХМАО) — крупнейший нефтедобывающий регион России, обеспечивающий около 40% добычи нефти","Уникальная экосистема с тайгой и болотами" ,"Здесь найдены древние городища и археологические артефакты","Занимает площадь 534,8 тыс. км² (сопоставимо с Испанией).","В Югре более 25 природных заповедников, включая «Юганский» и «Малая Сосьва»."};
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