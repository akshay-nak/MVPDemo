package com.akshay.demo.demoapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akshay.demo.demoapp.login.model.UserInfo;

/**
 * Created by akshay on 23/3/18.
 */
public class DatabaseManager implements IDatabaseManager {
    Context context;

    public DatabaseManager(Context context) {
        this.context = context;
    }

    @Override
    public void saveUserProfile(UserInfo userInfo) {

    }

    static class DatabaseHelper extends SQLiteOpenHelper {

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

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}