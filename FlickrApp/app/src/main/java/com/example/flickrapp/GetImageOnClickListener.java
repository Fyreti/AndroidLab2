package com.example.flickrapp;

import android.view.View;

public class GetImageOnClickListener implements View.OnClickListener {//on click
    @Override
    public void onClick(View v) {
        try{//allez chercher une image
            AsyncFlickrJSONData task = new AsyncFlickrJSONData("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json");
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
