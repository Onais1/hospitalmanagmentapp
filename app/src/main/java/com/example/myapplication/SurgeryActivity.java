package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SurgeryActivity extends AppCompatActivity {

    EditText edd, edt8, edt9, edt10;
    Button btn11, btn12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surgery);

        edd = findViewById(R.id.editTextText);
        edt8 = findViewById(R.id.editTextText8);
        edt9 = findViewById(R.id.editTextText9);
        edt10 = findViewById(R.id.editTextText10);

        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SurgeryActivity.this, HomeActivity.class));
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edd.getText().toString();
                String surgeon = edt8.getText().toString();
                String type = edt9.getText().toString();
                String date = edt10.getText().toString();

                Database db = new Database(getApplicationContext(), "Health", null, 1);
                if (surgeon.length() == 0 || date.length() == 0 || id.length() == 0 || type.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Details are incorrect, Please fill in again!", Toast.LENGTH_SHORT).show();
                } else {

                    if (isValid(id)) {
                        db.appointments(id, date);
                        Toast.makeText(getApplicationContext(), "Surgery record saved successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "You did not meet 'ID' requirements; minimum 3 characters using digits, letters and special symbols", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }

    // ID string criteria:
    // at least 1 special char
    // at least 1 letter
    // atl east 1 number
    public static boolean isValid (String id){
        int f1 = 0, f2 = 0, f3 = 0;
        if (id.length() < 3) {
            return false;
        } else {
            for (int p = 0; p < id.length(); p++) {
                if (Character.isLetter(id.charAt(p))) {
                    f1 = 1;
                }
            }
        }
        for (int r = 0; r < id.length(); r++) {
            if (Character.isDigit(id.charAt(r))) {
                f2 = 1;
            }
        }
        for (int s = 0; s < id.length(); s++) {
            char c = id.charAt(s);
            if (c > 33 && c <= 46 || c == 64) {
                f3 = 1;
            }
        }
        if (f1 == 1 && f2 == 1 && f3 == 1)
            return true;
        return false;



    }
}