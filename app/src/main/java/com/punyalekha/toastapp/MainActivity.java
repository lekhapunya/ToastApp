package com.punyalekha.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView display1;
    TextView display2;
    TextView display3;
    TextView display4;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("topleft", 0);
        editor.putInt("topright", 0);
        editor.putInt("bottomleft", 0);
        editor.putInt("bottomright", 0);
        editor.apply();
        display1=findViewById(R.id.textbox1);
        display2=findViewById(R.id.textbox2);
        display3=findViewById(R.id.textbox3);
        display4=findViewById(R.id.textbox4);
        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "";
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(v == display1) {
                    int setting = sharedPreferences.getInt("topleft", 0)+1;
                    editor.putInt("topleft", setting);
                    editor.apply();
                    text = "Top-left: " + setting;
                }if(v == display2) {
                    int setting = sharedPreferences.getInt("topright", 0)+1;
                    editor.putInt("topright", setting);
                    editor.apply();
                    text = "Top-right: " + setting;
                }if(v == display3) {
                    int setting = sharedPreferences.getInt("bottomleft", 0)+1;
                    editor.putInt("bottomleft", setting);
                    editor.apply();
                    text = "Bottom-left: " + setting;
                }if(v == display4) {
                    int setting = sharedPreferences.getInt("bottomright", 0)+1;
                    editor.putInt("bottomright", setting);
                    editor.apply();
                    text = "Bottom-right: " + setting;
                }
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();
            }
        };
        display1.setOnClickListener(l);
        display2.setOnClickListener(l);
        display3.setOnClickListener(l);
        display4.setOnClickListener(l);
    }
}
