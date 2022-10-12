package com.example.picnicstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class deliveryActivity extends AppCompatActivity {
    String name;
    String phone;
    String email;
    String adress;
    Button continuebtn;
    EditText nametxt;
    EditText phonetxt;
    EditText emailtxt;
    EditText adresstxt;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_activity);
        continuebtn =  (Button) findViewById(R.id.continuebtn);
        continuebtn.setOnClickListener(new Store());
        nametxt = (EditText) findViewById(R.id.fullName);
        phonetxt = (EditText) findViewById(R.id.phone);
        emailtxt = (EditText) findViewById(R.id.email);
        adresstxt = (EditText) findViewById(R.id.address);
    }
    private class Store implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            name = nametxt.getText().toString();
            if (name.length() == 0) {
                Toast.makeText(deliveryActivity.this, getString(R.string.noname), Toast.LENGTH_SHORT).show();
                return;
            }
            email = emailtxt.getText().toString();
            if (email.length() == 0) {
                Toast.makeText(deliveryActivity.this, getString(R.string.noemail), Toast.LENGTH_SHORT).show();
                return;
            }
            phone = phonetxt.getText().toString();
            if (phone.length() == 0) {
                Toast.makeText(deliveryActivity.this, getString(R.string.nophone), Toast.LENGTH_SHORT).show();
                return;
            }
           adress = adresstxt.getText().toString();
            if (adress.length() == 0) {
                Toast.makeText(deliveryActivity.this, getString(R.string.noadress), Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(deliveryActivity.this, StoreActivity.class);
            intent.putExtra("delivery", "delivery");
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", email);
            intent.putExtra("adress",adress);
            startActivity(intent);
        }
    }
}
