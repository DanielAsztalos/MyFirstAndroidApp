package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.Person;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    static final int PROFILE_INFO_REQUEST = 1;
    private int fromSignup = 0;
    private int fromProfile = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String from = new String("");
        from = intent.getStringExtra("FROM");
        if(from != null) {
            if(from.equals("SIGNUP")) {
                fromSignup += 1;
                ((TextView) findViewById(R.id.tv_no_calls_signup)).setText(String.valueOf(fromSignup));
                intent.removeExtra("FROM");
            }
            else if (from.equals("PROFILE")) {
                fromProfile += 1;
                ((TextView) findViewById(R.id.profileNumber)).setText(String.valueOf(fromProfile));
                intent.removeExtra("FROM");
            }
        }
    }

    // Navigate to Profile Activity
    public void toProfilePage(View view) {
        // Create new intent
        Intent intent = new Intent(this, ProfileActivity.class);

        // Get the values from firstName, lastName and department TextViews
        String firstName = ((TextView)findViewById(R.id.firstName)).getText().toString();
        String lastName = ((TextView) findViewById(R.id.lastName)).getText().toString();
        String department = ((TextView) findViewById(R.id.et_department)).getText().toString();

        // Check if firstName or lastName are empty
        if(firstName.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please, fill in the Fistname field", Toast.LENGTH_LONG).show();
            return;
        }

        if(lastName.length() == 0) {
            Toast.makeText(getApplicationContext(), "Plese, fill in the Lastname field", Toast.LENGTH_LONG).show();
            return;
        }

        // Create new person Object
        Person person = new Person(firstName, lastName, department);

        // Add it to the intent
        intent.putExtra("PERSON", person);
        intent.putExtra("FROM", "REGISTER");
        startActivityForResult(intent, PROFILE_INFO_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        // When the app returns with a result from the Profile Activity
        if(requestCode == PROFILE_INFO_REQUEST) {
            // And with RESULT_OK result
            if(resultCode == RESULT_OK) {
                // Get the returned person object from the result
                Person person = (Person) resultIntent.getSerializableExtra("PERSON");
                // Create the text to be displayed
                String textToDisplay = person.getFirstName() + " " + person.getLastName() + " from " + person.getDepartment() + " department";
                // Display the text
                ((TextView)findViewById(R.id.dataFromOutside)).setText(textToDisplay);

                fromProfile += 1;

                ((TextView) findViewById(R.id.profileNumber)).setText(String.valueOf(fromProfile));
            }
        }
    }
}
