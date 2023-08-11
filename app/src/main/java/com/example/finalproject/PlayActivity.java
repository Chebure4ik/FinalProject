package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private TextView textView, questionsOut;
    private Button firstOption, secondOption, thirdOption;
    private int playerAnswer = 0;
    private int a = -1;
    private int playerTurn = 1;
    final Random random = new Random();
    private int randomNumber;
    private int firstPlayer = 0, secondPlayer = 0, thirdPlayer = 0, fourthPlayer = 0;

    private String firstName, secondName, thirdName, fourthName;
    ArrayList<Integer> usedQuestions = new ArrayList<Integer>();
    String[]questions = {"Столица Белоруссии? \n 1.Киев \n 2.Москва \n 3.Минск", "Самое большое по площади озеро? \n 1. Титикака \n 2. Байкал \n 3. Каспийское море", "Высочайшая вершина? \n 1. Монблан \n 2. К2 \n 3. Джомолунгма ", " Длина экватора? \n 1. 10 000 км \n 2. 40 000 км \n 3. 150 000 км ", " Год открытия Америки? \n 1. 1322 \n 2. 1492 \n 3. 1812 ", "Первое кругосветное путешествие? \n 1. Колумб \n 2. Магеллан \n 3. Никитин ", " Вторая по высоте гора? \n 1. Лхоцзе \n 2. К2 \n 3. Аннапурна ", " Самое глубокое озеро? \n 1. Байкал \n 2. Онтарио \n 3. Иссык-Куль ",  " Горы, разделяющие Европу и Азию? \n 1. Альпы \n 2. Уральские \n 3. Алтайские ", " Река в Египте? \n 1. Замбези \n 2. Конго \n 3. Нил ", " Сколько континентов на Земле? \n 1. 6 \n 2. 5 \n 3. 4 "," Самый большой океан? \n 1. Тихий \n 2. Атлантический \n 3. Индийский "," Наибольшая глубина океана? \n 1. 9 км \n 2. 1940 м \n 3. 11 км "," Самый большой остров? \n 1. Великобритания \n 2. Мадагаскар \n 3. Гренландия "," Вулкан? \n 1. Помпеи  \n 2. Кракатау \n 3. Монблан "," Столица Камбоджи? \n 1. Пномпень \n 2. Бангкок \n 3. Лаос "," Столица Китая? \n 1. Шанхай \n 2. Пекин \n 3. Гуанчжоу "," Столица Перу? \n 1. Акапулько \n 2. Асунсьон \n 3. Лима "," Столица Греции? \n 1. Никосия \n 2. Афины \n 3. Александрия "," Столица Черногории? \n 1. Тирана \n 2. Белград \n 3. Подгорица "," Столица Дании? \n 1. Копенгаген \n 2. Осло \n 3. Стокгольм "," Крупнейший город Африки? \n 1. Каир \n 2. Лагос \n 3. Аккра "," Самый высокий водопад? \n 1. Ниагарский \n 2. Виктория \n 3. Анхель "," Самый объемный водопад? \n 1. Ниагарский \n 2. Виктория  \n 3. Игуасу "," Сколько в мире морей? \n 1. 102 \n 2. 63 \n 3. 17 "," Глубина Байкала? \n 1. 234 метра \n 2. 870 метров \n 3. 1642 метра "," В Северном полушарии проживает \n 1. 74% людей \n 2. 90% людей \n 3. 55% людей "," Вторая по площади страна? \n 1. Китай \n 2. Канада \n 3. США "," Столица Канады? \n 1. Ванкувер \n 2. Монреаль \n 3. Оттава "," Сколько стран в Африке? \n 1. 12 \n 2. 55 \n 3. 111 "," Широта на Экваторе? \n 1. 90 \n 2. 0 \n 3. 30 "," Страна на Экваторе? \n 1. Камбоджа \n 2. Эквадор \n 3. Вьетнам "," Где находится Анкор-Ват? \n 1. Мексика \n 2. Таиланд \n 3. Камбоджа "," Пингвины живут \n 1. На Северном полюсе \n 2. В Индии \n 3. В Африке "," Сколько штатов в США? \n 1. 57 \n 2. 55 \n 3. 50 "," Израиль граничит \n 1. С Египтом \n 2. С ОАЭ \n 3. С Россией "," Самое старое дерево? \n 1. 570 лет \n 2. 1250 лет \n 3. 5000 лет "," Где находится Йеллоустоун? \n 1. Канада \n 2. США \n 3. Танзания "," Где находится Мачу-Пикчу? \n 1. Мексика \n 2. Перу \n 3. Таиланд "," Где находится Везувий? \n 1. Италия \n 2. Индонезия \n 3. Черногория "," Самое маленькое государство? \n 1. Ватикан \n 2. Лихтенштейн \n 3. Монако "," Где находится Ватикан? \n 1. Франция \n 2. Италия \n 3. Испания "," Столица Испании? \n 1. Барселона \n 2. Гранада \n 3. Мадрид "," Самая длинная река? \n 1. Нил \n 2. Амазонка \n 3. Миссисипи "," Река в Африке? \n 1. Амазонка \n 2. Желтая река \n 3. Конго "," Река в Азии? \n 1. Конго \n 2. Меконг \n 3. Амазонка "," Где находится озеро Виктория? \n 1. Африка \n 2. Азия \n 3. Америка "," Сколько гор выше 8000 метров? \n 1. 11 \n 2. 14 \n 3. 7 "," Высочайшая вершина Европы? \n 1. Монблан \n 2. Эльбрус \n 3. Эверест "," Высочайшая вершина Африки? \n 1. Кракатау \n 2. Лхоцзе \n 3. Килиманджаро "," Пролив между Азией и Европой? \n 1. Берингов \n 2. Босфор \n 3. Дрейка "," Столица Турции? \n 1. Анкара \n 2. Стамбул \n 3. Анталья "};
    int[]answers = {3, 3, 3, 2, 2, 2, 2, 1, 2, 3, 1, 1, 3, 3, 2, 1, 2, 3, 2, 3, 1, 2, 3, 1, 2, 3,2, 2,3,2,2,2,3,3,3,1,3,2,2,1,1,2,3,1,3,2,1,2,2,3,2,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        textView = findViewById(R.id.textView);
        questionsOut = findViewById(R.id.questionsOut);
        firstOption = findViewById(R.id.firstOption);
        secondOption = findViewById(R.id.secondOption);
        thirdOption = findViewById(R.id.thirdOption);

        firstOption.setOnClickListener(listener);
        secondOption.setOnClickListener(listener);
        thirdOption.setOnClickListener(listener);

        playersName();
        textView.setText("Ходит игрок " + firstName);
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
        }
    };
    public void play(){
        if(firstPlayer < 12 && secondPlayer < 12 && thirdPlayer < 12 && fourthPlayer < 12){
            randomNumber = random.nextInt(52);
            if(!usedQuestions.contains(randomNumber)){
                usedQuestions.add(randomNumber);
                a = a + 1;
                questionsOut.setText(questions[usedQuestions.get(a)]);
            }
            else if(usedQuestions.contains(randomNumber) && usedQuestions.size() < 52){
                play();
            }
            else if (usedQuestions.size() == 52){
                questionsOut.setText("вопросы нетов");
            }
        }
        else{
            Intent intent = new Intent(getApplicationContext(), WinActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            intent.putExtra("point1", firstPlayer);
            intent.putExtra("point2", secondPlayer);
            intent.putExtra("point3", thirdPlayer);
            intent.putExtra("point4", fourthPlayer);

            intent.putExtra("name1", firstName);
            intent.putExtra("name2", secondName);
            intent.putExtra("name3", thirdName);
            intent.putExtra("name4", fourthName);

            startActivity(intent);
        }
    }

    public void correctAnswer(){
        if(playerTurn == 1){
            firstPlayer += 1;
            playerTurn = 2;
            textView.setText("Правильно \n теперь ход игрока " + secondName);
        } else if (playerTurn == 2) {
            secondPlayer += 1;
            if(thirdName == null){
                playerTurn = 1;
                textView.setText("Правильно \n теперь ход игрока " + firstName);
            } else {
                playerTurn = 1;
                textView.setText("Правильно \n теперь ход игрока " + thirdName);
            }
        } else if (playerTurn == 3) {
            thirdPlayer += 1;
            if(fourthName == null){
                playerTurn = 1;
                textView.setText("Правильно \n теперь ход игрока " + firstName);
            } else {
                playerTurn = 4;
                textView.setText("Правильно \n теперь ход игрока " + fourthName);
            }
        } else if (playerTurn == 4) {
            fourthPlayer +=1;
            playerTurn = 1;
            textView.setText("Правильно \n теперь ход игрока " + firstName);
        }
    }

    public void wrongAnswer(){
        if(playerTurn == 1){
            playerTurn = 2;
            textView.setText("Увы неправильно \n теперь ход игрока " + secondName);
        } else if (playerTurn == 2) {
            if(thirdName == null){
                playerTurn = 1;
                textView.setText("Увы неправильно \n теперь ход игрока " + firstName);
            } else {
                playerTurn = 3;
                textView.setText("Увы неправильно \n теперь ход игрока " + thirdName);
            }
        } else if (playerTurn == 3) {
            if(fourthName == null){
                playerTurn = 1;
                textView.setText("Увы неправильно \n теперь ход игрока " + firstName);
            } else {
                playerTurn = 4;
                textView.setText("Увы неправильно \n теперь ход игрока " + fourthName);
            }
        } else if (playerTurn == 4) {
            playerTurn = 1;
            textView.setText("Увы неправильно \n теперь ход игрока " + firstName);
        }
    }
    public void playersName(){
        Bundle names = getIntent().getExtras();

        if(names.get("nameIn3") == null){
            firstName = names.get("nameIn1").toString();
            secondName = names.get("nameIn2").toString();
        } else if (names.get("nameIn4") == null) {
            firstName = names.get("nameIn1").toString();
            secondName = names.get("nameIn2").toString();
            thirdName = names.get("nameIn3").toString();
        } else if (names.get("nameIn4") != null){
            firstName = names.get("nameIn1").toString();
            secondName = names.get("nameIn2").toString();
            thirdName = names.get("nameIn3").toString();
            fourthName = names.get("nameIn4").toString();
        }
    }
}