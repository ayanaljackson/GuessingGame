//Ayana Jackson
//Purpose: Create a guessing number game
//November 30, 2022
package edu.enmu.guessinggame;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    int RandomNumber;//integer for random number

    int attempts;
    Button buttonCheck;
    EditText editText;
    AlertDialog.Builder builder;
    final int threeAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //generate random number
        RandomNumber = 1 + (int) (100 * Math.random());
        editText= findViewById(R.id.etGuess);
        attempts = 0;
        buttonCheck = (Button) findViewById (R.id.buttonCheck);
        //new listener alert
        builder = new AlertDialog.Builder(this);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loop
                do{
                    int userGuess = Integer.parseInt(editText.getText().toString());
                    if(userGuess == RandomNumber){
                        builder.setTitle("Alert!").setMessage("The number you guessed is correct").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                    } else if (RandomNumber > userGuess){
                        builder.setTitle("Alert!").setMessage("The number you guessed is lower than the random number").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                    } else {
                        builder.setTitle("Alert!").setMessage("The number you guessed is higher than the random number").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                    }
                    attempts++;
                }while (attempts <= threeAttempts);
                builder.setTitle("Alert!").setMessage("Sorry, you only have 3 attempts to guess correctly").setCancelable(true).setPositiveButton("text", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

            }
        });
    }
}
