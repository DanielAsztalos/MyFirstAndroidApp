package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String PROFILE = "com.example.myfirstapp.PROFILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Navigate to the Register Activity
    public void toRegisterPage(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    // Navigate to the Profile Activity
    public void toProfilePage(View view) {
        // Get the contents of the firstName and lastName fields
        String firstName = ((TextView) findViewById(R.id.firstName)).getText().toString();
        String lastName = ((TextView) findViewById(R.id.lastName)).getText().toString();

        // Check if firstname or lastname is empty
        if(firstName.length() < 1) {
            Toast.makeText(getApplicationContext(), "Please, fill in the First Name field", Toast.LENGTH_LONG);
            return;
        }
        if(firstName.length() < 1) {
            Toast.makeText(getApplicationContext(), "Please, fill in the Last Name field", Toast.LENGTH_LONG);
            return;
        }

        // If not, create a new Person object with firstName and lastName params
        Person person = new Person(firstName, lastName);

        // Create intent and add the person object as extra
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("PERSON", person);
        startActivity(intent);
    }
}
