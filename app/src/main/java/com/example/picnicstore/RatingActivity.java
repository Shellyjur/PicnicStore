package com.example.picnicstore;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {
    RatingBar rating;
    TextView submitratingtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_activity);
        rating =(RatingBar) findViewById(R.id.rating);
        submitratingtxt =(TextView) findViewById(R.id.submitrating);
        submitratingtxt.setVisibility(View.INVISIBLE);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String stars = String.valueOf(rating);
                Toast.makeText(getApplicationContext(),getString(R.string.yourated)+stars,Toast.LENGTH_SHORT).show();
                submitratingtxt.setVisibility(View.VISIBLE);
            }
        });

    }

    //private class ChangeRating implements View.OnClickListener{
       // @Override
        //public void onClick(View v) {
            //String stars = String.valueOf(rating.getRating());
            //Toast.makeText(getApplicationContext(),getString(R.string.yourated)+stars,Toast.LENGTH_SHORT).show();
        //}
    //}

}
