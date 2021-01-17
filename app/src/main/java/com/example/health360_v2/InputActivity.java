package com.example.health360_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InputActivity extends AppCompatActivity {
    // Declarations for DB inserting
    EditText weight, calories, carbs, fiber, protein, sodium;
    Spinner choose_meal;
    String current_meal;
    Button submitbtn;
    DatabaseReference reff;
    MealValues mealvalues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.input_activity);
        // Show Toast message confirmation of firebase db connection
        Toast.makeText(InputActivity.this, "Firebase Connection: Success", Toast.LENGTH_LONG).show();

        choose_meal = findViewById(R.id.choose_meal);
        choose_meal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                current_meal = choose_meal.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // CODE FOR DB INSERTION BEGINS
        weight = (EditText)findViewById(R.id.enter_weight);
        calories = (EditText)findViewById(R.id.enter_calories);
        carbs = (EditText)findViewById(R.id.enter_carbs);
        fiber = (EditText)findViewById(R.id.enter_fiber);
        protein = (EditText)findViewById(R.id.enter_protein);
        sodium = (EditText)findViewById(R.id.enter_sodium);
        submitbtn = (Button)findViewById(R.id.submit_button);
        mealvalues = new MealValues();
        reff = FirebaseDatabase.getInstance().getReference().child("MealValues");

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double w = Double.parseDouble(weight.getText().toString().trim());
                double cal = Double.parseDouble(calories.getText().toString().trim());
                double car = Double.parseDouble(carbs.getText().toString().trim());
                double f = Double.parseDouble(fiber.getText().toString().trim());
                double p = Double.parseDouble(protein.getText().toString().trim());
                double sod = Double.parseDouble(weight.getText().toString().trim());
                mealvalues.setWeight(w);
                mealvalues.setCalories(cal);
                mealvalues.setCarbs(car);
                mealvalues.setFiber(f);
                mealvalues.setProtein(p);
                mealvalues.setSodium(sod);
                mealvalues.setCurrent_meal(current_meal.trim());
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                reff.child(currentDate).setValue(mealvalues);
                //Toast.makeText(InputActivity.this, "data inserted successfully", Toast.LENGTH_LONG).show();

            }
        });

//        // activity reopen when clicking "SUBMIT" button
//        @SuppressLint("CutPasteId") Button btnsubmit = (Button) findViewById(R.id.submit_button);
//        btnsubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                reopenInputActivity();
//            }
//        });

    }

//    // activity reopen when clicking "SUBMIT" button
//    public void reopenInputActivity() {
//        Intent intent = new Intent(this, InputActivity.class);
//        startActivity(intent);
//    }
}