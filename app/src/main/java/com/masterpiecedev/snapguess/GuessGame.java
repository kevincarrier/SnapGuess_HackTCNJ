package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuessGame extends AppCompatActivity {
    private int points = 0;
    celebrities celebrity = new celebrities();
    int gnum;
    String celebrityName;
    long timeLeftInMilliseconds;
    private TextView counterTimer;
    private CountDownTimer countDownTimer;
    private boolean timeRemaining;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

           // System.out.println("18 works");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_guess_game);

            Intent intent = getIntent();
            gnum = intent.getIntExtra("gnum", 0);
            timeLeftInMilliseconds = intent.getLongExtra("timeLeftInMilliseconds", 0);

        if(timeLeftInMilliseconds == 0)
        {
            Intent i = new Intent(GuessGame.this, loseGame.class);
            startActivity(i);
        }





        counterTimer = findViewById(R.id.counter_timer3);







            celebrityName = celebrity.getCelebrity()[gnum];

            TextView dashes = (TextView) findViewById(R.id.dashes);
            dashes.setText(convertToDashes());
            TextView points = (TextView) findViewById(R.id.points);
            points.setText("Points: " + celebrity.getPoints());
        final EditText guess = (EditText) findViewById(R.id.guess);

        // System.out.println(celebrityGuess +"30");
        final Button sendGuess = (Button) findViewById(R.id.sendGuess);
        sendGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println(celebrityGuess +"35");
                final String celebrityGuess = guess.getText().toString();
                sendGuess(celebrityGuess);
            }

        });

        CountDownTimerMethod();
    }


    protected String convertToDashes(){
        String dashes="";
        for(int i = 0; i <celebrityName.length(); i++){
            if(celebrityName.charAt(i) == (' '))
            dashes += ' ';
            else
            dashes +='-';
        }
        return dashes;
    }
    protected void sendGuess(String celebrityGuess)
    {
        TextView validity = (TextView) findViewById(R.id.validity);
       // System.out.println(celebrityGuess +"60");
        if (guessValid(celebrityGuess)) {
            validity.setText("Correct!");
            celebrity.points+=10;
            Intent intent = new Intent(this, drawGame.class);
            intent.putExtra("timeLeftInMilliseconds",timeLeftInMilliseconds);
            startActivity(intent);
        }
        else
            validity.setText("Sorry, try again!");
    }
    protected boolean guessValid(String celebrityGuess)
    {
        System.out.println(celebrityGuess + "sd " + celebrityName);
        if (celebrityName.toLowerCase().equals(celebrityGuess.toLowerCase()))
            return true;
        return false;
    }

    public void CountDownTimerMethod()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
    public void updateTimer(){

        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        //int minutes = (int) timeLeftInMilliseconds / 4000;
        //int seconds = (int) timeLeftInMilliseconds % 4000 / 1000;



        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        counterTimer.setText(timeLeftText);

    }

}
