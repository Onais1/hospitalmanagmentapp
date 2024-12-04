package com.example.myapplication;

public class Patient {
    private String ID;
    private String FullName;
    private String Gender;
    private String Age;
    private String DOB;
    private String Condition;
    private String Treatment;

    public Patient(String id, String fullName, String gender, String age, String dob, String condition, String treatment) {
        this.ID = id;
        this.FullName = fullName;
        this.Gender = gender;
        this.Age = age;
        this.DOB = dob;
        this.Condition = condition;
        this.Treatment = treatment;
    }

    public String getId() { return ID; }
    public String getFullName() { return FullName; }
    public String getGender() { return Gender; }
    public String getAge() { return Age; }
    public String getDob() { return DOB; }
    public String getCondition() { return Condition; }
    public String getTreatment() { return Treatment; }
}
