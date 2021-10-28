package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public void appInfo(View view) {
        Toast.makeText(this, "This App is Created By Pranav...!!", Toast.LENGTH_LONG).show();
    }
    boolean gameActive = true;
    //Player Representation
    //0 - X
    //1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    ///State Meanings
    //0 - X
    //1 - O
    //2 - Blank/Null
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
int x = 0 ;


    public void playerTap(View view) {
        if (!gameActive) {
            gameReset(view);
        }

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.red_o_toe);
                activePlayer = 1;
                TextView ststus = findViewById(R.id.status);
                ststus.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.blue_o_toe);
                activePlayer = 0;
                TextView ststus = findViewById(R.id.status);
                ststus.setText("X's Turn - Tap to Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Check if Someone has Won
        String winnerstr;
        int k = 0;
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                //Somebody has Won! - find Out Who !!
               //Initial winnweestr
                gameActive = false;
                k = 1;

                if (gameState[winPosition[0]] == 0) {
                    winnerstr = "X-Won!! - Tap to Replay";

                }
                else {
                   winnerstr = "O-Won!! - Tap to Replay";

                }
                //Update ststus bar for winner Announcement
                TextView ststus = findViewById(R.id.status);
                ststus.setText(winnerstr);
            }
            //Case for Draw start
            if(gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 && gameState[7]!=2 && gameState[8]!=2 && k == 0)
            {
                gameActive = false;
                winnerstr = "Draw!!";
                TextView ststus = findViewById(R.id.status);
                ststus.setText(winnerstr);
            }//Case for Draw close
    }
}
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView ststus = findViewById(R.id.status);
        ststus.setText("Welcome - Tap to Start!!");
    }
    /*
    try {
                    Thread.sleep(4000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}