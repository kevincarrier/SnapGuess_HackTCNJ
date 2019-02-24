package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class drawGame extends AppCompatActivity {

    celebrities celebrity = new celebrities();
    String [] celebrities =celebrity.getCelebrity();
    int[] celebrityImg = celebrity.getCelebrityImg();
    public int gnum;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_game);
        gnum = 4;//celebrity.genNum();
        if(gnum == -1)
            endGame();
        TextView celebrityName = (TextView) findViewById(R.id.celebrityName);
        celebrityName.setText(celebrities[gnum]);
        ImageView img = (ImageView) findViewById(R.id.celebrityImg);
        img.setImageResource(celebrityImg[gnum]);
        Button send = (Button) this.<View>findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuessGame(v);
            }
        });
    }

    public void GuessGame(View v) {
        Intent guessIntent = new Intent(drawGame.this, GuessGame.class);
        guessIntent.putExtra("gnum", gnum);
        startActivity(guessIntent);
    }

    public void endGame()
        {
            //System.out.println("hi");
            Intent endGame = new Intent(drawGame.this, endGame.class);
            startActivity(endGame);
        }


    }

