package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText editTextTextEmailAddress;
    public EditText editTextTextPassword;
    public TextView textViewResult;

    public Connection connection = new Connection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button ButtonAuthentification = findViewById(R.id.buttonAuthentification);

        ButtonAuthentification.setOnClickListener(new View.OnClickListener() {//When you click on the authencation button

            public void onClick(View v) {
                editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);//get your log
                editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);//get your password
                textViewResult = (TextView) findViewById(R.id.textViewResult);
                new Thread(){//Thread to start the authentification, and continue to use the app when that do the connection
                    @Override
                    public void run(){
                        Connect();

                    }

                }.start();

            }
        });

    }

    private void setResult(String s){
        runOnUiThread (new Thread(new Runnable() {
            public void run() {
                textViewResult.setText(s);
            }//Set the txtViewResult on the app
        }));
    }

    public void Connect(){
        setResult(connection.Connect(editTextTextEmailAddress, editTextTextPassword));// give the result of connection.Connect to setREsult

    }
}