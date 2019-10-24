package kiriel.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL1 = "NAME";
    public static final String COL3 = "PASSWORD";
    public static final String COL4 = "EMAIL";
    public static final String COL5 = "CONTACT";
    public static final String COL6 = "AGE";
    public static final String COL7 = "GENDER";

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(NAME TEXT,PASSWORD TEXT,EMAIL TEXT PRIMARY KEY,CONTACT TEXT,AGE INTEGER,GENDER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(String name, String password, String email, String contact, String age, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, name);
        contentValues.put(COL3, password);
        contentValues.put(COL4, email);
        contentValues.put(COL5, contact);
        contentValues.put(COL6, age);
        contentValues.put(COL7, gender);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public boolean validEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+TABLE_NAME +" where " + COL4 + "=?", new String[]{email});
        if(cursor.getCount()>0){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean validLogin(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME + " where " + COL4 + "=? and " + COL3 + "=?", new String[]{email,password});
        if(cursor.getCount()>0){
            return true;
        } else{
            return false;
        }
    }

    public boolean updateData(String name, String contact, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, name);
        contentValues.put(COL5, contact);
        contentValues.put(COL6, age);
        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { name });
        db.close();
        return true;
    }

}
