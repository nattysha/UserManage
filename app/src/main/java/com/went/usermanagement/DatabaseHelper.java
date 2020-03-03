package com.went.usermanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME= "user_info";
    public static final String fname= "name";
    public static final String usrname= "username";
    public static final String phone= "phone";
    public static final String email= "email";
    public static final String password = "password";
    public static final String Gender = "Gender";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + TABLE_NAME +
                " ( "
                + fname + " text,"
                + usrname + " text ,"
                + phone + " int ,"
                + email + " text ,"
                + password + " text ,"
                + Gender + " text "
                + " ) ";
        db.execSQL(createUserTable);
        System.out.println ( "database creatded" );
    }


    //called when the database needs to upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);

        }


    public long insert(USER user ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        //contentValues.put("imgUri",imgPath);
        contentValues.put("name",user.getFull_name ());
        contentValues.put("username",user.getUsername());
        contentValues.put("phone",user.getPhone());
        contentValues.put("email",user.getEmail());
        contentValues.put("password",user.getPassword());
        contentValues.put("Gender",user.getGender ());
        long result= db.insert(TABLE_NAME,null,contentValues);
        return result;
    }
    public List getAllData() {
        SQLiteDatabase db= getReadableDatabase ();
        String query="SELECT * FROM "+TABLE_NAME;
        List list=new ArrayList();
        Cursor res = db.rawQuery(query,null);
        while (res.moveToNext())
        {
            list.add(new USER (res.getString(0),
                    res.getString(1),
                    res.getString (2),
                    res.getString (3),
                    res.getString (4),
                    res.getString (5)));
        }
        return list;

    }
    public Boolean getForLogin(String mail){
        SQLiteDatabase db = getReadableDatabase ();
        String filter = email + " , " + password;
        String condition = "'"+ mail +"'" + " = " + email;
        Cursor res = db.rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE " + condition, null );
        boolean r=false;
        if (res.getCount()!=0) {
            r = true;
        }
        return r;
    }
    public Cursor getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT *FROM usertable", null);
    }
}
