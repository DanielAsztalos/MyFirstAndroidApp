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

        this.person = (Person) getIntent().getSerializableExtra("PERSON");

        TextView firstNameTV = (TextView) findViewById(R.id.tv_first_name);
        firstNameTV.setText(person.getFirstName());

        TextView lastNameTV = (TextView) findViewById(R.id.tv_last_name);
        lastNameTV.setText(person.getLastName());

        TextView departmentTV = (TextView) findViewById(R.id.tv_department);
        departmentTV.setText(person.getDepartment());
    }

    public void back(View view) {
        Intent resultIntent  = new Intent();
        resultIntent.putExtra("PERSON", this.person);
        setResult(RESULT_OK, resultIntent);

        finish();
    }
}
