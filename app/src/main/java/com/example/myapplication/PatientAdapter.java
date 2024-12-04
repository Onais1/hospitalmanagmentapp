package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private List<Patient> patientList;

    public PatientAdapter(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_find_patient2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.edFullName.setText("Name: " + patient.getFullName());
        holder.edGender.setText("Gender: " + patient.getGender());
        holder.edAge.setText("Age: " + patient.getAge());
        holder.edDob.setText("DOB: " + patient.getDob());
        holder.edCondition.setText("Condition: " + patient.getCondition());
        holder.edTreatment.setText("Treatment: " + patient.getTreatment());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        EditText edId,edFullName, edGender, edAge, edDob, edCondition, edTreatment;

        public ViewHolder(View itemView) {
            super(itemView);
            edFullName = itemView.findViewById(R.id.editTextText4);
            edGender = itemView.findViewById(R.id.editTextText5);
            edAge = itemView.findViewById(R.id.editTextNumber);
            edDob = itemView.findViewById(R.id.editTextDate2);
            edCondition = itemView.findViewById(R.id.editTextText6);
            edTreatment = itemView.findViewById(R.id.editTextText7);
            edId = itemView.findViewById(R.id.editTextNumber2);
        }
    }
}
