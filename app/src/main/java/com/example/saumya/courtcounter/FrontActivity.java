package com.example.saumya.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FrontActivity extends AppCompatActivity {

    EditText player1Name,player2Name,numberOfSets;
    RadioGroup radioGroupGameType,radioGroupService;
    RadioButton radioButton10pts,radioButton20pts,serviceIs1,serviceIs2;
    Button startButton;
    int service;
    int gameType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        //linking xml
        player1Name = (EditText) findViewById(R.id.player1Name);
        player2Name = (EditText) findViewById(R.id.player2Name);
        numberOfSets = (EditText) findViewById(R.id.numberOfSets);
        serviceIs1 = (RadioButton) findViewById(R.id.serviceIs1);
        serviceIs2 = (RadioButton) findViewById(R.id.serviceIs2);
        radioGroupGameType = (RadioGroup)findViewById(R.id.radioGroupGameType);
        radioGroupService = (RadioGroup)findViewById(R.id.radioGroupService);
        startButton = (Button) findViewById(R.id.startButton);
        radioButton10pts = (RadioButton) findViewById(R.id.radioButton10pts);
        radioButton20pts = (RadioButton) findViewById(R.id.radioButton20pts);


       startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

                // obtaining whoes serice is first..
               int selectedIdService = radioGroupService.getCheckedRadioButtonId();
               if(selectedIdService == serviceIs1.getId()){
                   service=1;
               }else if(selectedIdService== serviceIs2.getId()){
                   service=2;
               }

               //obtain the game type
               int selectedIdGameType=radioGroupGameType.getCheckedRadioButtonId();
               if(selectedIdGameType == radioButton10pts.getId()){
                   gameType=10;
               }else if(selectedIdGameType == radioButton20pts.getId()){
                   gameType=20;
               }

               //obtaing player names and no of sets
               String firstPlayer = player1Name.getText().toString();
               String secondPlayer = player2Name.getText().toString();
               int sets = Integer.parseInt(numberOfSets.getText().toString());

               //creating intent and putting data
               Intent intent = new Intent(FrontActivity.this,CounterActivity.class);
               intent.putExtra("player1",firstPlayer);
               intent.putExtra("player2",secondPlayer);
               intent.putExtra("sets",sets);
               intent.putExtra("service",service);
               intent.putExtra("gameType",gameType);
               startActivity(intent);
               finish();

           }
       });
    }
}
