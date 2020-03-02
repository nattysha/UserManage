package com.went.usermanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DBAdapter extends SQLiteOpenHelper {
   private static final String dbName="StudentReg.db";
    private static final String tableName="Students";
    private static final int verion=2;
    private static final String id="_id";
    private  static final String name="fname";
    private static final String userName="username";
    private static final String Gender="Gender";
    private static final String Email="Email";
    private static final String PhoneNo="PhoneNo";
    private static final String Password="Password";
    String columns[]={id, name, userName, Gender, Email, PhoneNo,Password};

    public DBAdapter(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int verion){
        super(context, dbName,factory,verion);
    }
//    public DBAdapter(Context context){
//        super(context,dbName,null,verion);
//    }

    public static String getId() {
        return id;
    }

    public Cursor query(String sql, String[] selectargs){
        SQLiteDatabase db= getWritableDatabase();
        return db.rawQuery(sql,selectargs);
    }
    public void insertData(String name, String userName, String gender,String Email, String PhoneNo,  String Password){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Insert into Students values(101," +name+ "text,"+ userName +"text," +gender +"text,"+ Email+"text, "+PhoneNo +"int," +Password+"text)" ;
        db.close();
    }
    public void insertRecord(String fname, String userName, String gender,String Email, String PhoneNo,  String Password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.name,fname);
        contentValues.put(this.userName,userName);
        contentValues.put(this.Gender,Gender);
        contentValues.put(this.Email,Email);
        contentValues.put(this.PhoneNo,PhoneNo);
        contentValues.put(this.Password,Password);
        db.insert(tableName,null ,contentValues);

    }

    public void updateData(String name, String userName, String Gender,String Email, String PhoneNo,  String Password, int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql= "Update Students Set fname= ?, username= ?, Gender= ?, Email= ?, PhoneNo= ?, Password= ? where id= ?";
        SQLiteStatement statement= db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(0, name);
        statement.bindString(1, userName);
        statement.bindString(2, Gender);
        statement.bindString(3, Email);
        statement.bindString(4, PhoneNo);
        statement.bindString(5, Password);
        statement.bindDouble(6,(double)id);

        statement.execute();
        db.close();
    }
    public void deleteData(String fullName){
        SQLiteDatabase db= getWritableDatabase();
        db.delete(tableName,"fullName "+"=\"" + fullName+"\"", null);
        db.close();
    }
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }
    public Cursor getAllData(){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery("Select * from Students",null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE Students("+ getId() +" INTEGER PRIMARY KEY AUTOINCREMENT, name Text, username Text, Gender Text, Email Text, PhoneNo int, Password Text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists "+ tableName);
        onCreate(db);
    }
}

