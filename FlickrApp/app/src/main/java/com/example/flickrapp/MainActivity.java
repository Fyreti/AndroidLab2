package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button GitImage;
    private Button GoToList;
    private static ImageView img;
    public static Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.image);
        GoToList = (Button)findViewById(R.id.GoToList);//Bouton pour allez sur la vue de la liste d'image
        GitImage = (Button)findViewById(R.id.Getimage);//bouton pour avoir l'image aléatoire
        GitImage.setOnClickListener(new GetImageOnClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
            }
        });
        GoToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listPage = new Intent(MainActivity.this, ListActivity.class);
                startActivity(listPage);//lancé une nouvelle activitée (page) pour afficher la liste d'image
            }
        });
    }

    public static void setRes(Bitmap bm){
        img.setImageBitmap(bm);
    }//set l'image quand on appuis sur Getimage
}