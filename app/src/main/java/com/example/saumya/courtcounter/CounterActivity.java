package com.example.saumya.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CounterActivity extends AppCompatActivity {

    LinearLayout layoutPlayer1,layoutPlayer2;

    TextView player1TextView,player2TextView,player1PointsTV,player2PointsTV,setsTextView;
    Button pointIncButton1,pointIncButton2;
    int service,gameType,sets;
    String player1Name,player2Name;

    int setPointsPlayer1,setPointsPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        player1TextView = (TextView) findViewById(R.id.player1TextView);
        player2TextView = (TextView) findViewById(R.id.player2TextView);
        player1PointsTV = (TextView)findViewById(R.id.player1PointsTV);
        player2PointsTV = (TextView) findViewById(R.id.player2PointsTV);
        setsTextView = (TextView) findViewById(R.id.setsTextView);
        pointIncButton1 = (Button) findViewById(R.id.pointIncButton1);
        pointIncButton2  = (Button) findViewById(R.id.pointIncButton2);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        sets = b.getInt("sets");
        service = b.getInt("service");
        gameType = b.getInt("gameType");
        player1Name= b.getString("player1");
        player2Name=b.getString("player2");

        setsTextView.setText("SET : "+sets);
        player1TextView.setText(""+player1Name);
        player2TextView.setText(""+player2Name);

        

    }
}
