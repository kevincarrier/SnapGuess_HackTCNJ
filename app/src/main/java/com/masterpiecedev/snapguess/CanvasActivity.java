package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    private PaintView paintView;
    //private Paint paint;
    int gnum;
    long timeLeftInMilliseconds;
    private TextView counterTimer;
    private CountDownTimer countDownTimer;
    private boolean timeRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setContentView(R.layout.activity_canvas);
        paintView = (PaintView) findViewById(R.id.paintView);
        //paint = new Paint();

        Intent intent = getIntent();
        gnum = intent.getIntExtra("gnum", 0);
        timeLeftInMilliseconds = intent.getLongExtra("timeLeftInMilliseconds", 0);

        if(timeLeftInMilliseconds == 0)
        {
            Intent i = new Intent(CanvasActivity.this, loseGame.class);
            startActivity(i);
        }
        //counterTimer = findViewById(R.id.counter_timer2);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        Button send = (Button) this.<View>findViewById(R.id.goToNextWindow);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToGuess(v);
            }
        });

        //CountDownTimerMethod();
    }


    public void GoToGuess(View v) {
        Intent guessIntent = new Intent(CanvasActivity.this, GuessGame.class);
        guessIntent.putExtra("gnum", gnum);
        guessIntent.putExtra("timeLeftInMilliseconds",timeLeftInMilliseconds);
        startActivity(guessIntent);
    }


    /*public void CountDownTimerMethod()
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

    }*/



    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.black:
                paint.setColor(Color.BLACK);
                return true;
            case R.id.brown:
                paint.setColor(Color.parseColor("#A52A2A"));
                return true;
            case R.id.peach:
                paint.setColor(Color.parseColor("#ffdab9"));
                return true;
            case R.id.yellow:
                paint.setColor(Color.YELLOW);
                return true;
            case R.id.clear:
                paintView.clear();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
