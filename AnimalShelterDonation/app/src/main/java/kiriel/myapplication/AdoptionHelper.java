package kiriel.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdoptionHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "adoption.db";
    public static final String TABLE_NAME = "adoption_table";
    public static final String COL1 = "NAME";
    public static final String COL3 = "AGE";
    public static final String COL4 = "GENDER";
    public static final String COL5 = "WEIGHT";
    public static final String COL6 = "HEIGHT";

    SQLiteDatabase db;

    public AdoptionHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(NAME TEXT PRIMARY KEY, AGE TEXT, GENDER TEXT, WEIGHT TEXT, HEIGHT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addAnimal(String name, String age, String gender, String weight, String height) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, name);
        contentValues.put(COL3, age);
        contentValues.put(COL4, gender);
        contentValues.put(COL5, weight);
        contentValues.put(COL6, height);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

}
