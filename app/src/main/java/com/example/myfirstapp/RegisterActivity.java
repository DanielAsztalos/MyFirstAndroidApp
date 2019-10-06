package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    static final int PROFILE_INFO_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void toProfilePage(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);

        Person person = new Person();
        person.setFirstName(((TextView)findViewById(R.id.firstName)).getText().toString());
        person.setLastName(((TextView) findViewById(R.id.lastName)).getText().toString());
        person.setDepartment(((TextView) findViewById(R.id.et_department)).getText().toString());

        intent.putExtra("PERSON", person);
        startActivityForResult(intent, PROFILE_INFO_REQUEST);
    }
}
