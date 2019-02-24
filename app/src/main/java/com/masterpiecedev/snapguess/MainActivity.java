package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rules = (Button) findViewById(R.id.rules);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules(v);
            }
        });
        Button drawGame = (Button) this.<View>findViewById(R.id.drawGame);
        drawGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawGame(v);
            }
        });
    }
    protected void rules(View v)
    {
        Intent rulesIntent = new Intent(this, Rules.class);
        startActivity(rulesIntent);

    }
    protected void drawGame(View v)
    {
        Intent drawGame = new Intent(this, drawGame.class);
        startActivity(drawGame);

    }
}
