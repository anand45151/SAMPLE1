package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NEWUSER(username text,pass text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop Table if exists NEWUSER");
    }
    public Boolean insertdata(String username,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("pass",pass);
        long result = db.insert("NEWUSER",null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkuser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from NEWUSER where username = ?",new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checknamepass(String username,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from NEWSER where username  = ? and pass = ?",new String[]{username,pass});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;

        }
    }
}
