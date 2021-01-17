package com.example.health360_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        // activity switch when clicking "HOME" button
        Button home_btn = (Button) findViewById(R.id.home_button);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openInputActivity();
            }
        });

        // activity switch when clicking "RECORDS" button
        Button records_btn = (Button) findViewById(R.id.records_button);
        records_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRecordActivity();
            }
        });
    }

    public void openInputActivity() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    public void openRecordActivity() {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }
}