package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;

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

        try
        {
            if (SnapLogin.isUserLoggedIn(this)) {

                Intent displayIntent = new Intent(this, homePage2.class);
                startActivity(displayIntent);

            }else{

                View mLoginButton = SnapLogin.getButton(getApplicationContext(), (ViewGroup)findViewById(R.id.content_frame));
                RelativeLayout.LayoutParams testLP = new RelativeLayout.LayoutParams(1000, 200);

                testLP.addRule(RelativeLayout.CENTER_HORIZONTAL);


                mLoginButton.setLayoutParams(testLP);
            }

            final LoginStateController.OnLoginStateChangedListener mLoginStateChangedListener =
                    new LoginStateController.OnLoginStateChangedListener() {
                        @Override
                        public void onLoginSucceeded() {

                            Intent displayIntent = new Intent(MainActivity.this, drawGame.class);
                            startActivity(displayIntent);
                        }


                        @Override
                        public void onLoginFailed() {

                        }

                        @Override
                        public void onLogout() {

                            SnapLogin.getAuthTokenManager(MainActivity.this).revokeToken();
                            Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_LONG).show();
                            recreate();
                        }
                    };


            SnapLogin.getLoginStateController(this).addOnLoginStateChangedListener(mLoginStateChangedListener);
        }
        catch(Exception ex)
        {
            Log.e("Error", ex.getMessage());
        }

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
