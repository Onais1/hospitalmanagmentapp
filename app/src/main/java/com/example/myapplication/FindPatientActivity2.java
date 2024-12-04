package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FindPatientActivity2 extends AppCompatActivity {

    EditText edFullName, edGender, edID;
    Button btn7, btn8;

    TextView tv;

    RecyclerView RV;
    RecyclerView recyclerView;
    PatientAdapter patientAdapter;
    Database dbHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_patient2);
        edFullName = findViewById(R.id.editTextText33);
        edGender = findViewById(R.id.editTextText2);
        edID = findViewById(R.id.editTextText3);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        tv = findViewById(R.id.textView6);
        RV = findViewById(R.id.recyclerView22);

        RV.setLayoutManager(new LinearLayoutManager(this));

        recyclerView = findViewById(R.id.recyclerView22);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}