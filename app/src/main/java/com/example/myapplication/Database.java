package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // user login table
        String qry1 = "create table users(id int, username text, email text, password text)";
        sqLiteDatabase.execSQL(qry1);

        // patient info table
        String qry2 = "create table patients(id int, fullName text, gender text, age text, dob text, condition text, treatment text)";
        sqLiteDatabase.execSQL(qry2);

        // appointments table
        String qry3 = "create table appointments(id int, day text, month text, year text, time text)";
        sqLiteDatabase.execSQL(qry3);

        // surgery table
        String qry4 = "create table surgery(id int, surgeon text, type text, date int)";
        sqLiteDatabase.execSQL(qry4);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void appointments(String id, String date){
        ContentValues cv = new ContentValues();
        cv.put("Date", date);
        cv.put("ID", id);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("appointments", null, cv);
        db.close();
    }

    public void surgery(String id, String surgeon, String type, String date){
        ContentValues cv = new ContentValues();

        cv.put("ID", id);
        cv.put("Surgeon", surgeon);
        cv.put("Type", type);
        cv.put("Date", date);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("surgery", null, cv);
        db.close();
    }

    public void patient(String id, String fullName, String gender, String age, String dob, String condition, String treatment){
        ContentValues cv = new ContentValues();
        cv.put("Full Name", fullName);
        cv.put("ID", id);
        cv.put("Gender", gender);
        cv.put("Age", age);
        cv.put("DOB", dob);
        cv.put("Condition", condition);
        cv.put("Treatment", treatment);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("patients", null, cv);
        db.close();
    }

    public void register(String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String username, String password){
        int result=0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }



    public int findAppointment(String id, String day, String month, String year, String time){
        int result=0;
        String str[] = new String[5];
        str[0] = day;
        str[1] = month;
        str[2] = year;
        str[3] = time;
        str[4] = id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from appointments where id=? and day=? and month=? and year=? and time=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }




}


