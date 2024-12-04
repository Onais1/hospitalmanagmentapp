package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PatientActivity extends AppCompatActivity {

    EditText  edId,edFullName, edGender, edAge, edDob, edCondition, edTreatment;
    Button btn4, btn5, btn6;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient);


        edFullName = findViewById(R.id.editTextText4);
        edGender = findViewById(R.id.editTextText5);
        edAge = findViewById(R.id.editTextNumber);
        edDob = findViewById(R.id.editTextDate2);
        edCondition = findViewById(R.id.editTextText6);
        edTreatment = findViewById(R.id.editTextText7);
        edId = findViewById(R.id.editTextNumber2);
        tv = findViewById(R.id.textView5);

        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn4 = findViewById(R.id.button4);
        // create patient button5 will save patient details in patient table
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = edFullName.getText().toString();
                String gender = edGender.getText().toString();
                String id = edId.getText().toString();
                String age = edAge.getText().toString();
                String dob = edDob.getText().toString();
                String condition = edCondition.getText().toString();
                String treatment = edTreatment.getText().toString();
                Database db = new Database(getApplicationContext(), "Health", null, 1);
                if (fullName.length() == 0 || gender.length() == 0 || id.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "Details are incorrect, Please fill in again!", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (isValid(id)) {
                            db.patient(id, fullName, gender, age, dob, condition, treatment);
                            Toast.makeText(getApplicationContext(), "Patient record saved successfully!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "You did not meet 'ID' requirements; minimum 3 characters using digits, letters and special symbols", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        });

        //Redirect to Home page after successfully registering patient.
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientActivity.this, HomeActivity.class));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientActivity.this, HomeActivity.class));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientActivity.this, FindPatientActivity2.class));
            }
        });

    };



        // ID string criteria:
        // at least 1 special char
        // at least 1 letter
        // atl east 1 number
        public static boolean isValid(String id) {
        int f1=0, f2=0, f3=0;
        if (id.length() < 3) {
            return false;
        } else {
            for (int p = 0; p < id.length(); p++) {
                if (Character.isLetter(id.charAt(p))) {
                    f1=1;
                }
            }
        }
        for (int r = 0; r < id.length(); r++) {
            if (Character.isDigit(id.charAt(r))) {
                f2=1;
            }
        }
        for (int s = 0; s < id.length(); s++) {
            char c = id.charAt(s);
            if(c>33&&c<=46||c==64){
                f3=1;
            }
        }
        if(f1==1 && f2==1 && f3==1)
            return true;
        return false;


    }


}