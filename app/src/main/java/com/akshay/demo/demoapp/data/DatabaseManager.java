package com.akshay.demo.demoapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akshay.demo.demoapp.login.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

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
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", userInfo.getFull_name());
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance(context);
        databaseHelper.getWritableDatabase().insert("user_info", null, contentValues);
        databaseHelper.close();
    }

    @Override
    public UserInfo getUserInfo() {
        UserInfo user = null;
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance(context);
        Cursor cursor = databaseHelper.getWritableDatabase().rawQuery("Select * from user_info", null);
        if (cursor != null) {
            if (cursor.moveToNext()) {
                user = new UserInfo(cursor.getString(cursor.getColumnIndex("full_name")));
                user.setId(cursor.getInt(0));
            }

        }
        if (cursor != null) {
            cursor.close();
        }
        if (databaseHelper != null) {
            databaseHelper.close();
        }
        return user;
    }

    @Override
    public void clear() {
        DatabaseHelper.getDatabaseInstance(context).clearDatabase();
    }
}