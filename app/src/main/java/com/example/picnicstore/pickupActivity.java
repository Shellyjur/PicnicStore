package com.example.picnicstore;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.timepicker.TimeFormat;

import java.text.DateFormat;
import java.util.Calendar;

public class pickupActivity extends AppCompatActivity {
    Button continuebtn;
    String time;
    String date;
    String name;
    String phone;
    String email;
    EditText nametxt;
    EditText phonetxt;
    EditText emailtxt;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup_activity);
        nametxt = (EditText) findViewById(R.id.fullName);
        phonetxt = (EditText) findViewById(R.id.phone);
        emailtxt = (EditText) findViewById(R.id.email);
        Button date_btn= (Button) findViewById(R.id.datepickbtn);
        TextView displaydate_txt=(TextView)findViewById(R.id.showdate);
        continuebtn =  (Button) findViewById(R.id.continuebtn);
        continuebtn.setOnClickListener(new Store());
        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                int year =c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datepick = new DatePickerDialog(pickupActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        date =  getString(R.string.chosenDate);
                        date+= " "+dayOfMonth +"."+month+"."+year;
                        displaydate_txt.setText(getString(R.string.chosenDate)+" "+dayOfMonth +"."+month+"."+year);

                    }
                },year,month,day);
                datepick.getDatePicker().setMinDate(new Date().getTime());
                datepick.show();
            }
        });
        Button time_btn=(Button) findViewById(R.id.timepickbtn);
        TextView displaytime_txt=(TextView)findViewById(R.id.showtime);
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);
                TimePickerDialog timepick = new TimePickerDialog(pickupActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time = getString(R.string.chosenTime);
                        time +=" " + hourOfDay+":"+minute;
                        displaytime_txt.setText(getString(R.string.chosenTime) + " " + hourOfDay+":"+minute);
                    }
                },hour,minutes,true);
                timepick.show();
            }
        });

    }
    private class Store implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            name = nametxt.getText().toString();
            if(name.length()==0){
                Toast.makeText(pickupActivity.this,getString(R.string.noname),Toast.LENGTH_SHORT).show();
                return;
            }
            email = emailtxt.getText().toString();
            if(email.length()==0){
                Toast.makeText(pickupActivity.this,getString(R.string.noemail),Toast.LENGTH_SHORT).show();
                return;
            }
            phone = phonetxt.getText().toString();
            if(phone.length()==0){
                Toast.makeText(pickupActivity.this,getString(R.string.nophone),Toast.LENGTH_SHORT).show();
                return;
            }
            if(date==null){
                Toast.makeText(pickupActivity.this,getString(R.string.nodate),Toast.LENGTH_SHORT).show();
                return;
            }
            if(time==null){
                Toast.makeText(pickupActivity.this,getString(R.string.notime),Toast.LENGTH_SHORT).show();
                return;
            }


            Intent intent= new Intent(pickupActivity.this,StoreActivity.class);
            intent.putExtra("pickup","pickup");
            intent.putExtra("name",name);
            intent.putExtra("phone",phone);
            intent.putExtra("email",email);
            intent.putExtra("date",date);
            intent.putExtra("time",time);
            startActivity(intent);
        }
    }

}
