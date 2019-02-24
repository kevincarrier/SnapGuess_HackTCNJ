package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuessGame extends AppCompatActivity {
    private int points = 0;
    celebrities celebrity = new celebrities();
    String [] celebrities =celebrity.getCelebrity();
    int[] celebrityImg = celebrity.getCelebrityImg();
    int gnum;
    String celebrityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

           // System.out.println("18 works");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_guess_game);

            Intent intent = getIntent();
            gnum = intent.getIntExtra("gnum", 0);
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

}
