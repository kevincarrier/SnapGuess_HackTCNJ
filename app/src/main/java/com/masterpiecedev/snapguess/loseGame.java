package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loseGame extends AppCompatActivity {
    celebrities celebrity = new celebrities();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_game);
        celebrity.resetNumsUsed();
        TextView points = (TextView) findViewById(R.id.points);
        points.setText("You got "  + celebrity.getPoints() + " points!");
        Button tohome = (Button) this.<View>findViewById(R.id.tohome);
        tohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backButton = new Intent(loseGame.this, MainActivity.class);
                startActivity(backButton);
            }
        });
    }
}
