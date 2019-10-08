package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private Person person;
    private int fromSignup = 0;
    private int fromRegister = 0;

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

    public void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String from = new String("");
        try {
            from = intent.getStringExtra("FROM");
        }catch (Exception e){
        }

        if(from != null) {
            if(from.equals("SIGNUP")) {
                fromSignup += 1;
                ((TextView) findViewById(R.id.tv_no_calls_from_signup)).setText(String.valueOf(fromSignup));
                intent.removeExtra("FROM");
            }
            else if (from.equals("REGISTER")) {
                fromRegister += 1;
                ((TextView) findViewById(R.id.tv_no_of_calls_reg)).setText(String.valueOf(fromRegister));
                intent.removeExtra("FROM");
            }
        }
    }

    public void back(View view) {
        // When the back button is clicked send back the person object to the Register Activity
        Intent resultIntent  = new Intent();
        resultIntent.putExtra("PERSON", this.person);
        resultIntent.putExtra("FROM", "PROFILE");
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
