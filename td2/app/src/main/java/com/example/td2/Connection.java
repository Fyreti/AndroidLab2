package com.example.td2;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection  {

    public Connection(){

    }

    public String Connect(EditText editTextTextEmailAddress, EditText editTextTextPassword) {
        URL url = null;
        try {

            url = new URL("https://httpbin.org/basic-auth/bob/sympa");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            String logPas = editTextTextEmailAddress.getText().toString() +":"+ editTextTextPassword.getText().toString() ;//set the log and pass to verifie them
            String basicAuth = "Basic " + Base64.encodeToString(logPas.getBytes(),
                    Base64.NO_WRAP);
            urlConnection.setRequestProperty ("Authorization", basicAuth);
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());//test if log and pass are good
                String s = readStream(in);//take the result of urlConnection
                Log.i("JFL", s);
                return s;

            } finally {
                urlConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }


    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
