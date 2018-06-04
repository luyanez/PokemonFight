package com.example.android.courtcounter;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePichu;   //Variable to save the score of Pichu
    int scoreTogepi;  //Variable to save the score of Togepi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            scorePichu = 100;
            scoreTogepi = 100;
        }
        else{
            scorePichu = savedInstanceState.getInt("scorePichu");
            scoreTogepi = savedInstanceState.getInt("scoreTogepi");
        }
        displayForTogepi(scoreTogepi);
        displayForPichu(scorePichu);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("scorePichu", scorePichu);
        savedInstanceState.putInt("scoreTogepi", scoreTogepi);

        super.onSaveInstanceState(savedInstanceState);
    }

    //onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        scorePichu = savedInstanceState.getInt("scorePichu");
        scoreTogepi = savedInstanceState.getInt("scoreTogepi");

    }

    /* Function name: validateScores
       Input value:   int score
       Output value:  boolean (true, false)
       Description:   This function validates the score, if it is equal or less to 0
                      it will show a Dialog message with the "Game over" text
                      and it will reset the scores
     */
    private boolean validateScores(int score) {
        if (score <= 0) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setCancelable(false);
            dialog.setTitle(R.string.gameOverMessage);
            dialog.setMessage(R.string.gameOver);
            dialog.setPositiveButton(R.string.resetText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //Action for "Reset".
                    reset();
                }
            });

            final AlertDialog alert = dialog.create();
            alert.show();

            return true;
        }
        return false;

    }

    /* Function name: displayForTogepi
       Input value:   int score
       Output value:  void
       Description:   This function will display the score for Togepi
     */
    public void displayForTogepi(int score) {
        TextView scoreTogepiView = (TextView) findViewById(R.id.team_togepi_score);
        scoreTogepiView.setText(String.valueOf(score));
    }

    /* Function name: subsMegaTogepi
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 20 points to the scorePichu
     */
    public void subsMegaTogepi(View v) {
        scorePichu -= 20;
        if(!validateScores(scorePichu)) {
            displayForPichu(scorePichu);
        }
    }

    /* Function name: subsDizzyTogepi
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 15 points to the scorePichu
     */
    public void subsDizzyTogepi(View v) {
        scorePichu -= 15;
        if(!validateScores(scorePichu)) {
            displayForPichu(scorePichu);
        }
    }

    /* Function name: subsHitTogepi
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 10 points to the scorePichu
     */
    public void subsHitTogepi(View v) {
        scorePichu -= 10;
        if(!validateScores(scorePichu)) {
            displayForPichu(scorePichu);
        }
    }

    /* Function name: subsRageTogepi
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 5 points to the scorePichu
     */
    public void subsRageTogepi(View v) {
        scorePichu -= 5;
        if(!validateScores(scorePichu)) {
            displayForPichu(scorePichu);
        }
    }

    /* Function name: displayForPichu
       Input value:   int score
       Output value:  void
       Description:   This function will display the score for Pichu
     */
    public void displayForPichu(int score) {
        TextView scorePichuView = (TextView) findViewById(R.id.team_pichu_score);
        scorePichuView.setText(String.valueOf(score));
    }

    /* Function name: subsMegaPichu
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 20 points to the scoreTogepi
     */
    public void subsMegaPichu(View v) {
        scoreTogepi -= 20;
        if(!validateScores(scoreTogepi)) {
            displayForTogepi(scoreTogepi);
        }
    }

    /* Function name: subsDizzyPichu
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 15 points to the scoreTogepi
     */
    public void subsDizzyPichu(View v) {
        scoreTogepi -= 15;
        if(!validateScores(scoreTogepi)) {
            displayForTogepi(scoreTogepi);
        }
    }

    /* Function name: subsHitPichu
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 10 points to the scoreTogepi
     */
    public void subsHitPichu(View v) {
        scoreTogepi -= 10;
        if(!validateScores(scoreTogepi)) {
            displayForTogepi(scoreTogepi);
        }
    }

    /* Function name: subsRagePichu
       Input value:   View v
       Output value:  void
       Description:   This function will reduce 5 points to the scoreTogepi
     */
    public void subsRagePichu(View v) {
        scoreTogepi -= 5;
        if(!validateScores(scoreTogepi)) {
            displayForTogepi(scoreTogepi);
        }
    }

    /* Function name: resetScores
       Input value:   View v
       Output value:  void
       Description:   This function calls the private function reset in order to reset the scores
     */
    public void resetScores(View v) {
        reset();
    }

    /* Function name: reset
       Input value:   void
       Output value:  void
       Description:   This function reset the original values and display them
     */
    private void reset() {
        scorePichu = 100;
        scoreTogepi = 100;
        displayForPichu(scorePichu);
        displayForTogepi(scoreTogepi);
    }


}
