package com.example.flighwar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class DialogScoreBoard extends AppCompatActivity {

    public EditText yourScore,scoreResult;
    public ImageView goBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_activity);

        final SharedPreferences preferences = this.getSharedPreferences("game", MODE_PRIVATE);

        LayoutInflater inflater = this.getLayoutInflater();

        //goBack = findViewById(R.drawable.ic_arrow_back_black_24dp);
        yourScore = findViewById(R.id.yourScore);
        scoreResult = findViewById(R.id.scoreResult);

        scoreResult.setText("Your higher score is:" + preferences.getInt("highscore", 0));

        /*findViewById(R.drawable.ic_arrow_back_black_24dp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DialogScoreBoard.this, GameActivity.class));
            }
        });*/
    }
}
