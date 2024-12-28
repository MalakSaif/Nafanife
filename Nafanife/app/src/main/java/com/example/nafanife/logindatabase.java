package com.example.nafanife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class logindatabase extends SQLiteOpenHelper {
    public static final String ldb = "logindatabase.db";
    public static final String acdetails = "abayacustomerdetails";
    public static final String acustname = "acustname";
    public static final String acustpass = "acustpassword";

    public logindatabase(Context context) {
        super(context, ldb, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + acdetails + " (" + acustname + " TEXT PRIMARY KEY, " + acustpass + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldlogin_db, int newlogin_db) {
        db.execSQL("DROP TABLE IF EXISTS " + acdetails);
        onCreate(db);
    }

    public boolean addabayacustomer(String Acustname, String Acustpass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(acustname, Acustname);
        contentValues.put(acustpass, Acustpass);
        long result = db.insert(acdetails, null, contentValues);
        db.close();
        return result != -1;
    }

    public String getcustpassword(String abayacustname) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + acustpass + " FROM " + acdetails + " WHERE " + acustname + " = ?", new String[]{abayacustname});
        String password = null;
        if (cursor.moveToFirst()) {
            password = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return password;
    }

    public Cursor getabayacustaccounts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + acdetails, null);
    }
}
