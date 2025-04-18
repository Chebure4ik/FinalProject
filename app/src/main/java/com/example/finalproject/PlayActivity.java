package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private TextView textView, questionsOut;
    private Button firstOption, secondOption, thirdOption;
    private ProgressBar progressBar;
    private int playerAnswer = 0;
    private int a = -1 , b = 1, i;
    private int playerTurn = 1;
    final Random random = new Random();
    private int randomNumber;
    private int firstPlayer = 0;
    ArrayList<Integer> usedQuestions = new ArrayList<Integer>();
    String[]questions = {"Как называется столица ХМАО? \n 1.Ханты-Мансийск \n 2.Сургут \n 3. Нижневартовск","Коренными народами ХМАО являются:\n 1.Ханты и манси \n 2.Ненцы и татары \n 3.Якуты и эвенки","Какой народный промысел традиционно развит в ХМАО? \n 1. Ткачество \n 2. Резьба по дереву \n 3. Керамика","Какое месторождение нефти является одним из крупнейших в ХМАО? \n 1. Южно-Ягунское \n 2. Ванкорское \n 3. Приобское","Какой из этих природных объектов является памятником природы в ХМАО? \n 1. гора Народная \n 2. Костяная гора \n 3. Уральские горы"," В каком году был образован Ханты-Мансийский автономный округ? \n 1. 1940 \n 2. 1930 \n 3. 1993"," Какой из этих проектов связан с развитием туризма в ХМАО? \n 1. Золотое кольцо России \n 2. Сибирская тропа \n 3. Полярная экспедиция","Как называется традиционная лодка коренных народов Севера? \n 1. Облас \n 2.Каноэ  \n 3. Байдарка","Какой вид спорта наиболее популярен в Югре? \n 1. Футбол \n 2. Биатлон \n 3. Шахматы","Какая река протекает через ХМАО? \n 1. Иртыш \n 2. Енисей \n 3. Лена","Какой из этих городов НЕ входит в ХМАО? \n 1. Когалым \n 2. Мегион \n 3. Тобольск","Какой традиционный музыкальный инструмент используют ханты и манси? \n 1. Варган \n 2. Эрху \n 3. Нарс-юх"};
    String[]easyQuestions = {"Как называется столица ХМАО? \n 1.Ханты-Мансийск \n 2.Сургут \n 3. Нижневартовск","Коренными народами ХМАО являются:\n 1.Ханты и манси \n 2.Ненцы и татары \n 3.Якуты и эвенки","Какой народный промысел традиционно развит в ХМАО? \n 1. Ткачество \n 2. Резьба по дереву \n 3. Керамика","Какое месторождение нефти является одним из крупнейших в ХМАО? \n 1. Южно-Ягунское \n 2. Ванкорское \n 3. Приобское","Какой из этих природных объектов является памятником природы в ХМАО? \n 1. гора Народная \n 2. Костяная гора \n 3. Уральские горы"," В каком году был образован Ханты-Мансийский автономный округ? \n 1. 1940 \n 2. 1930 \n 3. 1993"," Какой из этих проектов связан с развитием туризма в ХМАО? \n 1. Золотое кольцо России \n 2. Сибирская тропа \n 3. Полярная экспедиция","Как называется традиционная лодка коренных народов Севера? \n 1. Облас \n 2.Каноэ  \n 3. Байдарка","Какой вид спорта наиболее популярен в Югре? \n 1. Футбол \n 2. Биатлон \n 3. Шахматы","Какая река протекает через Ханты-Мансийск? \n 1. Иртыш \n 2. Енисей \n Лена","Какой из этих городов НЕ входит в ХМАО? \n 1. Когалым \n 2. Мегион \n 3. Тобольск","Какой традиционный музыкальный инструмент используют ханты и манси? \n 1. Варган \n 2. Эрху \n 3. Нарс-юх"};
    String[]normalQuestions = {};
    String[]hardQuestions = {};
    int[]answers = {1, 1, 2, 3, 1, 2, 2, 1, 3, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 1, 2, 3, 1, 2, 3,2, 2,3,2,2,2,3,3,3,1,3,2,2,1,1,2,3,1,3,2,1,2,2,3,2,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        textView = findViewById(R.id.textView);
        questionsOut = findViewById(R.id.questionsOut);
        firstOption = findViewById(R.id.firstOption);
        secondOption = findViewById(R.id.secondOption);
        thirdOption = findViewById(R.id.thirdOption);
        progressBar = findViewById(R.id.progressBar);

        firstOption.setOnClickListener(listener);
        secondOption.setOnClickListener(listener);
        thirdOption.setOnClickListener(listener);
        play();
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.firstOption:
                    playerAnswer = 1;
                    break;
                case R.id.secondOption:
                    playerAnswer = 2;
                    break;
                case R.id.thirdOption:
                    playerAnswer = 3;
                    break;
            }
            if(playerAnswer == answers[randomNumber]){
                correctAnswer();
            }
            else{
                wrongAnswer();
            }
            play();
            progressBar.setProgress(progressBar.getProgress() + 1);
            textView.setText(Integer.toString(b) + " из 12");
            b = b+1;
            i = i+1;
        }
    };
    public void play(){
        if(i < 11){
            randomNumber = random.nextInt(12);
            if(!usedQuestions.contains(randomNumber)){
                usedQuestions.add(randomNumber);
                a = a + 1;
                questionsOut.setText(questions[usedQuestions.get(a)]);
            }
            else if(usedQuestions.contains(randomNumber) && usedQuestions.size() < 52){
                play();
            }
        }
        else{
            Intent intent = new Intent(getApplicationContext(), WinActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            intent.putExtra("point1", firstPlayer);

            startActivity(intent);
        }
    }

    public void correctAnswer(){
        firstPlayer = firstPlayer + 1;
    }

    public void wrongAnswer(){
    }
}