package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class homePage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        Button rules2 = (Button) findViewById(R.id.rules2);
        rules2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules2(v);
            }

        });
        Button drawGame2 = (Button) this.<View>findViewById(R.id.drawGame2);
        drawGame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawGame2(v);
            }
        });
    }
    protected void rules2(View v)
    {
        Intent rulesIntent = new Intent(this, Rules.class);
        startActivity(rulesIntent);

    }
    protected void drawGame2(View v)
    {
        Intent drawGame = new Intent(this, drawGame.class);
        startActivity(drawGame);

    }
}
