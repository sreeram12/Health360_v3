package com.example.health360_v2;

import com.example.health360_tools.TextNutrition;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class InputActivity extends AppCompatActivity implements ImageToText.ImageToTextCompleteListener {

    private ImageToText imageToText;
    private static final String TAG = "INPUT_ACTIVITY";
    private Button camButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_activity);

        camButton = findViewById(R.id.cam_button);
        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Starting image to text");
                imageToText.start();
            }
        });

        imageToText = new ImageToText(getApplicationContext(), this);
        imageToText.setOnImageToTextComplete(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        imageToText.extractText(requestCode, resultCode, data);

    }

    @Override
    public void onImageToTextComplete(String s) {
        Log.d(TAG, s);
        Log.d(TAG, new TextNutrition(s.split("\n")).toString());
    }

}