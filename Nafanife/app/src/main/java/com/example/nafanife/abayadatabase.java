package com.example.nafanife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class abayadatabase extends SQLiteOpenHelper {
    public static final String adb = "abayadatabase.db";
    public static final String atable = "abayainfo";
    public static final String aname = "abayaname";
    public static final String aquantity = "totalquantity";
    public static final String acost = "abayatotalcost";
    public static final String adate = "date";
    public static final String acustphno = "abayacustomerphno";

    public abayadatabase(Context context) {
        super(context, adb, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + atable + " ("
                + aname + " TEXT PRIMARY KEY, "
                + aquantity + " TEXT, "
                + acost + " TEXT, "
                + adate + " TEXT, "
                + acustphno + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase abbdb, int oldabaya_db, int newabaya_db) {
        abbdb.execSQL("DROP TABLE IF EXISTS " + atable);
        onCreate(abbdb);
    }

    public boolean addabayas1(String abaya_ID, String totalquantity, String totalabayacostt, String datee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(aname, abaya_ID);
        contentValues.put(aquantity, totalquantity);
        contentValues.put(acost, totalabayacostt);
        contentValues.put(adate, datee);

        long result = db.insert(atable, null, contentValues);
        db.close();
        return result != -1;
    }

    public int deleteabayas(String abayaname) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(atable, aname + "=?", new String[]{abayaname});
    }

    public Cursor showabayainfo(String abayaname) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + atable + " WHERE " + aname + "=?", new String[]{abayaname});
        return cursor;
    }

    public Cursor showabayas() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + atable, null);
    }

    public boolean updatename(String abayaID, String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(adate, newName);

        int rowsAffected = db.update(atable, contentValues, aname + " = ?", new String[]{abayaID});
        db.close();

        return rowsAffected > 0;
    }
}
