package com.example.picnicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button confirmBtn;
    Button declineBtn;
    TextView messageAcordingPress;
    TextView welcomeMessage;
    TextView legalMessage;
    TextView storeinfo;
    TextView deliveryinfo;
    Button deliveryBtn;
    Button pickupBtn;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageAcordingPress= findViewById(R.id.messageAcordingPress);
        legalMessage = findViewById(R.id.LegalMessage);
        welcomeMessage = findViewById(R.id.Welcome);
        messageAcordingPress.setVisibility(View.INVISIBLE);
        confirmBtn = findViewById(R.id.Confirm_btn);
        declineBtn= findViewById(R.id.Decline_btn);
        storeinfo = findViewById(R.id.storeinfo);
        deliveryinfo = findViewById(R.id.deliveryinfo);
        confirmBtn.setOnClickListener(new Confirm());
        declineBtn.setOnClickListener(new Decline());



    }
    private class Decline implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            declineBtn.setVisibility(View.GONE);
            confirmBtn.setVisibility(View.GONE);
            welcomeMessage.setVisibility(View.GONE);
            legalMessage.setVisibility(View.GONE);
            messageAcordingPress.setText(""+getString(R.string.LegalMessage));
            messageAcordingPress.setVisibility(View.VISIBLE);



        }
    }
    private class Confirm implements View.OnClickListener{

        @Override
        public void onClick(View v) {
          declineBtn.setVisibility(View.GONE);
          confirmBtn.setVisibility(View.GONE);
          welcomeMessage.setVisibility(View.GONE);
          legalMessage.setVisibility(View.GONE);
          messageAcordingPress.setText(""+getString(R.string.OrderChoice));
          messageAcordingPress.setVisibility(View.VISIBLE);
          deliveryBtn= new Button(MainActivity.this);
          pickupBtn = new Button(MainActivity.this);
          deliveryBtn.setBackground(getDrawable(R.drawable.shape_selector));
          pickupBtn.setBackground(getDrawable(R.drawable.shape_selector));
          LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
          params.setMargins(0,15,0,0);
          pickupBtn.setLayoutParams(params);
          deliveryBtn.setLayoutParams(params);
          LinearLayout layout = (LinearLayout)findViewById(R.id.linearlayout);
          deliveryBtn.setText(R.string.Delivery);
          pickupBtn.setText(R.string.PickUp);
          layout.addView(deliveryBtn);
          layout.addView(pickupBtn);
          //deliveryBtn.setOnClickListener();
          pickupBtn.setOnClickListener(new PickUp());
          deliveryBtn.setOnClickListener(new Delivery());
          storeinfo.setText(""+ getString(R.string.StoreInfo) + System.getProperty("line.separator")+getString(R.string.Adress)+" "+ getString(R.string.Street) + System.getProperty("line.separator")
          + getString(R.string.WorkingHours) + " "+ getString(R.string.HourDescription));
          deliveryinfo.setText(" "+getString(R.string.deliveryinfo) + System.getProperty("line.separator")
                  + getString(R.string.deliverytime));

        }
        private class PickUp implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                deliveryBtn.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this,pickupActivity.class);
                startActivity(intent);
                finish();
            }
        }
        private class Delivery implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                pickupBtn.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this,deliveryActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

}