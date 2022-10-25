package com.example.fuel_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "login.db";
    public DBHelper( Context context) {
        super(context, "login.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, password TEXT, nic TEXT, nameinitials TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username, String password, String nic, String nameinitials){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("nic", nic);
        values.put("nameinitials", nameinitials);

        long result = db.insert("users", null, values);
        return result != -1;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});
        return cursor.getCount() > 0;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[] {username,password});
        return cursor.getCount() > 0;
    }
}
