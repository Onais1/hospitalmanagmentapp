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
    EditText edUser,edEmail, edRegUser, edRegPass, edDate, edPhone, edPostCode;
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
        edDate = findViewById(R.id.editTextDate);
        edPhone = findViewById(R.id.editTextPhone);
        edPostCode = findViewById(R.id.editTextTextPostalAddress);
        btn = findViewById(R.id.buttonRegUser);
        tv = findViewById(R.id.textViewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edRegUser.getText().toString();
                String email = edEmail.getText().toString();
                String password = edRegPass.getText().toString();
                if(username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(),"Details are incorrect, Please fill in again", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_SHORT).show();
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
}