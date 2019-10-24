package kiriel.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DonationHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "donation.db";
    public static final String TABLE_NAME = "donation_table";
    public static final String COL1 = "AMOUNT_DONATED";

    SQLiteDatabase db;

    public DonationHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + "(AMOUNT_DONATED TEXT PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addDonation(String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, amount);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

}
