package com.masterpiecedev.snapguess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.snapchat.kit.sdk.SnapLogin;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.btnUnlink:
                UnlinkFromSnap();
                break;
            default:
                break;
        }
        return true;
    }

    public void UnlinkFromSnap()
    {
        SnapLogin.getAuthTokenManager(this).revokeToken();
        Intent backToLogin = new Intent(this, MainActivity.class);
        startActivity(backToLogin);
    }

    /*public void checkIfAuthenticatedWithSnapChat()
    {
        if (SnapLogin.isUserLoggedIn(this)) {

        String query = "{me{bitmoji{avatar},displayName}}";


        SnapLogin.fetchUserData(this, query, null, new FetchUserDataCallback() {
            @Override
            public void onSuccess(@Nullable UserDataResponse userDataResponse) {
                if (userDataResponse == null || userDataResponse.getData() == null) {
                    return;
                }

                MeData meData = userDataResponse.getData().getMe();
                if (meData == null) {
                    return;
                }
                TextView mNameTextView = findViewById(R.id.mySnapName);
                ImageView mBitmojiImageView = findViewById(R.id.mySnapBitmoji);

                mNameTextView.setText(userDataResponse.getData().getMe().getDisplayName());

                if (meData.getBitmojiData() != null) {
                    Glide.with(getApplicationContext())
                            .load(meData.getBitmojiData().getAvatar())
                            .into(mBitmojiImageView);
                }
            }

            @Override
            public void onFailure(boolean isNetworkError, int statusCode) {

            }
        });

    }*/

}

