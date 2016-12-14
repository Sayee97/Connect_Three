package com.example.android.connect_three;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    boolean gameActive=true;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winningPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
public void dropIn(View viw){
    ImageView counter = (ImageView)viw;
    int setCounter=Integer.parseInt(counter.getTag().toString());
    if(gameState[setCounter]==2 && gameActive){
        gameState[setCounter]=activePlayer;
    counter.setTranslationY(-1000f);
    if(activePlayer==0){
    counter.setImageResource(R.drawable.yellow);
    activePlayer=1;}
    else
    {
        counter.setImageResource(R.drawable.red);
        activePlayer=0;
    }
    counter.animate().translationYBy(1000f).rotation(360f).setDuration(1000);
        for(int[] win:winningPos){
            if(gameState[win[0]]==gameState[win[1]] && gameState[win[1]]==gameState[win[2]] && gameState[win[0]]!=2)
            {
                gameActive=false;
                String winner = "Red Disc";
                if(gameState[win[0]]==0){
                    winner="Yellow Disc";
                }
                TextView ti = (TextView)findViewById(R.id.winnerMessage);
                ti.setText(winner +" has won!!!");
                LinearLayout  li = (LinearLayout)findViewById(R.id.baby);
                li.setVisibility(View.VISIBLE);
            }
            else
            {
                boolean gameOver=true;
                for(int couter:gameState){
                    if(couter==2)
                        gameOver=false;


                }
                if(gameOver){
                    TextView ti = (TextView)findViewById(R.id.winnerMessage);
                    ti.setText("Game Over!!!");
                    LinearLayout  li = (LinearLayout)findViewById(R.id.baby);
                    li.setVisibility(View.VISIBLE);
                }
            }
        }

}
else
    {
        Toast.makeText(getApplicationContext(),"Sorry...Box is already occupied",Toast.LENGTH_LONG);
    }}
public void playAgain(View v){
gameActive=true;
    LinearLayout  li = (LinearLayout)findViewById(R.id.baby);
    li.setVisibility(View.INVISIBLE);
    activePlayer=0;
    for(int i=0;i<gameState.length;i++)
        gameState[i]=2;
    GridLayout gl = (GridLayout)findViewById(R.id.gll);
    for(int j=0;j<gl.getChildCount();j++){
        ((ImageView) gl.getChildAt(j)).setImageResource(0);
    }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
