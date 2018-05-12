package com.akshay.demo.demoapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akshay on 12/5/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "MY_DATABASE";
    static final int DB_VERSION = 101;

    static DatabaseHelper dbInstance;

    private DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    static synchronized DatabaseHelper getDatabaseInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = new DatabaseHelper(context);
        }
        return dbInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user_info (_id integer primary key autoincrement, full_name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void clearDatabase() {
        // query to obtain the names of all tables in your database
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        List<String> tables = new ArrayList<>();

        // iterate over the result set, adding every table name to a list
        while (c.moveToNext()) {
            tables.add(c.getString(0));
        }

        // call DROP TABLE on every table name
        for (String table : tables) {
            if (!table.equals("sqlite_sequence")) {
                String deleteQuery = "DELETE from " + table;
                db.execSQL(deleteQuery);
            }
        }
        if (c != null)
            c.close();

        if (db != null)
            db.close();
    }

}
