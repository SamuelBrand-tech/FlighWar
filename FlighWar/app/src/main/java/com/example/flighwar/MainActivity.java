package com.example.flighwar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public Button play,register,buttonHaveAccount;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(MainActivity.this,GameActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        register = findViewById(R.id.buttonGoToRegister);
        play = findViewById(R.id.buttonPlay);
        buttonHaveAccount = findViewById(R.id.buttonHaveAccount);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GameActivity.class));

            }
        });

        buttonHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHaveAccountDialog();
            }
        });

    }

    private void buttonHaveAccountDialog() {
        DialogHaveAccount DialogHaveAccount = new DialogHaveAccount();
        DialogHaveAccount.show(getSupportFragmentManager(), "show dialog");
    }



    private void openDialog() {
        OpenDialog openDialog = new OpenDialog();
        openDialog.show(getSupportFragmentManager(), "show dialog");
    }

//    private void updateUI(FirebaseUser currentUser) {
//        if(currentUser != null){
//            startActivity(new Intent(MainActivity.this,GameActivity.class));
//        }
//        else{
//            openDialog();
//        }
//    }

}
