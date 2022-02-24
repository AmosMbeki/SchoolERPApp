package it.com.ke;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "registration.db";



    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "registration.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("CREATE TABLE users(email TEXT PRIMARY KEY, password TEXT, phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("DROP TABLE IF EXISTS users");
    }

    public Boolean insertData(String email, String password, String phone){
        SQLiteDatabase myDatabase = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put("email", email);
        contentValue.put("password", password);
        contentValue.put("phone", phone);

        return true;
    }
}
