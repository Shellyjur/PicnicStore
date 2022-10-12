package com.example.picnicstore;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StoreActivity extends AppCompatActivity {
    Button orderbtn;
    TextView summary;
    TextView scroll;
    Button finish;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);
        finish =(Button) findViewById(R.id.finish);
        finish.setVisibility(View.INVISIBLE);
        finish.setOnClickListener(new Gotorate());
        summary = (TextView) findViewById(R.id.ordersummarytxt);
        summary.setVisibility(View.INVISIBLE);
        summary.setVisibility(View.INVISIBLE);
        scroll =(TextView) findViewById(R.id.scroll);
        scroll.setVisibility(View.INVISIBLE);
        orderbtn =(Button) findViewById(R.id.orderbtn);
        orderbtn.setOnClickListener(new Dynamiccreate());
        String info;
        TextView persondetailstxt = (TextView) findViewById(R.id.persondetails);
        Intent intent = getIntent();
        if(intent.hasExtra("pickup")){
            info=getString(R.string.orderinfo)+System.getProperty("line.separator")+getString(R.string.ordertype)+" "
                    +getString(R.string.PickUp) +System.getProperty("line.separator");
            info+= getString(R.string.fullname) +": "+ getIntent().getStringExtra("name") + System.getProperty("line.separator")
                    +getString(R.string.phone)+ ": "+ getIntent().getStringExtra("phone") + System.getProperty("line.separator")
                    +getString(R.string.email)+": "+getIntent().getStringExtra("email") +System.getProperty("line.separator")
                    +getIntent().getStringExtra("date") +System.getProperty("line.separator")
                    +getIntent().getStringExtra("time") +System.getProperty("line.separator");
            persondetailstxt.setText(info);
        }
        else{
            info=getString(R.string.orderinfo)+System.getProperty("line.separator")+getString(R.string.ordertype)+" "
                    +getString(R.string.Delivery) +System.getProperty("line.separator");
            info+= getString(R.string.fullname) +": "+ getIntent().getStringExtra("name") + System.getProperty("line.separator")
                    +getString(R.string.phone)+ ": "+ getIntent().getStringExtra("phone") + System.getProperty("line.separator")
                    +getString(R.string.email)+": "+getIntent().getStringExtra("email") +System.getProperty("line.separator")
                    +getString(R.string.Adress) + getIntent().getStringExtra("adress");
            persondetailstxt.setText(info);
        }
    }


    private class Dynamiccreate implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish.setVisibility(View.VISIBLE);
            orderbtn.setVisibility(View.GONE);
            summary.setVisibility(View.VISIBLE);
            scroll.setText(getString(R.string.scroll));
            scroll.setVisibility(View.VISIBLE);
            int wine,bread,cheese,basket;
            EditText winetxt =(EditText) findViewById(R.id.wineamount);
            EditText breadxt =(EditText) findViewById(R.id.breadamount);
            EditText cheesetxt =(EditText) findViewById(R.id.cheeseamount);
            EditText baskettxt =(EditText) findViewById(R.id.basketamount);
            //TableLayout table =(TableLayout) findViewById(R.id.tabledynamic);
            TableLayout table = new TableLayout(StoreActivity.this);
            table.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT));
            LinearLayout layout = findViewById(R.id.tabledynamic);
            String check = winetxt.getText().toString();
            if(check.length()!=0){
                wine = Integer.parseInt(check);
                for(int i=0;i<wine;i++){
                    TableRow tr =new TableRow(StoreActivity.this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.MATCH_PARENT));
                    ImageView wineimage =new ImageView(StoreActivity.this);
                    wineimage.setImageDrawable(getDrawable(R.drawable.whinebottle));
                    tr.addView(wineimage);
                    table.addView(tr);
                }

            }
            check = breadxt.getText().toString();
            if(check.length()!=0){
                bread = Integer.parseInt(check);
                for(int i=0;i<bread;i++){
                    TableRow tr =new TableRow(StoreActivity.this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.MATCH_PARENT));
                    ImageView breadimage =new ImageView(StoreActivity.this);
                    //breadimage.setLayoutParams(new android.view.ViewGroup.LayoutParams(150,250));
                    breadimage.setImageDrawable(getDrawable(R.drawable.bread));
                    tr.addView(breadimage);
                    table.addView(tr);
                }
            }
            check = cheesetxt.getText().toString();
            if(check.length()!=0){
                cheese = Integer.parseInt(check);
                for(int i=0;i<cheese;i++){
                    TableRow tr =new TableRow(StoreActivity.this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.MATCH_PARENT));
                    ImageView cheeseimage =new ImageView(StoreActivity.this);
                    //cheeseimage.setLayoutParams(new android.view.ViewGroup.LayoutParams(150,250));
                    cheeseimage.setImageDrawable(getDrawable(R.drawable.platecheese));
                    tr.addView(cheeseimage);
                    table.addView(tr);
                }
            }
            check = baskettxt.getText().toString();
            if(check.length()!=0){
                basket = Integer.parseInt(check);
                for(int i=0;i<basket;i++){
                    TableRow tr =new TableRow(StoreActivity.this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.MATCH_PARENT));
                    ImageView basketimage =new ImageView(StoreActivity.this);
                    //basketimage.setLayoutParams(new android.view.ViewGroup.LayoutParams(150,250));
                    basketimage.setImageDrawable(getDrawable(R.drawable.basket));
                    tr.addView(basketimage);
                    table.addView(tr);
                }
            }
            layout.addView(table);


        }
    }
    private class Gotorate implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(StoreActivity.this,RatingActivity.class);
            startActivity(intent);
       }
    }

}

