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

public class RegisterActivity extends AppCompatActivity {
    EditText edUser,edEmail, edRegUser, edRegPass, edDate, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        edEmail = findViewById(R.id.editTextEmail);
        edUser = findViewById(R.id.editTextRegUser);
        edRegUser = findViewById(R.id.editTextRegUser);
        edRegPass = findViewById(R.id.editTextRegPass);
        edConfirm = findViewById(R.id.editTextRegConfirm);
        edDate = findViewById(R.id.editTextDate);

        btn = findViewById(R.id.buttonRegUser);
        tv = findViewById(R.id.textViewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edRegUser.getText().toString();
                String email = edEmail.getText().toString();
                String password = edRegPass.getText().toString();
                String confirm = edConfirm.getText().toString();
                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Details are incorrect, Please fill in again!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm) == 0) {
                        if (isValid(password)) {

                            Toast.makeText(getApplicationContext(), "User logins saved successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "You did not meet password requirements; minimum 10 characters using digits, letters and special symbols", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password did not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
    public static boolean isValid(String passwordhere) {
        int f1=0, f2=0, f3=0;
        if (passwordhere.length() < 10) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1=1;
                }
            }
        }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2=1;
            }
        }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if(c>33&&c<=46||c==64){
                f3=1;
            }
        }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;


    }
}