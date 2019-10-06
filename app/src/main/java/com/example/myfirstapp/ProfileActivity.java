package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get Person object from intent
        this.person = (Person) getIntent().getSerializableExtra("PERSON");

        // Set the value of the firstName TextView
        TextView firstNameTV = (TextView) findViewById(R.id.tv_first_name);
        firstNameTV.setText(person.getFirstName());

        // Set the value of the lastName TextView
        TextView lastNameTV = (TextView) findViewById(R.id.tv_last_name);
        lastNameTV.setText(person.getLastName());

        // Set the value of the department TextView
        TextView departmentTV = (TextView) findViewById(R.id.tv_department);
        departmentTV.setText(person.getDepartment());
    }

    public void back(View view) {
        // When the back button is clicked send back the person object
        Intent resultIntent  = new Intent();
        resultIntent.putExtra("PERSON", this.person);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
