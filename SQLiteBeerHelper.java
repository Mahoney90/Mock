package com.mahoneyapps.tapitfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brendan on 3/14/2016.
 */
public class SQLiteBeerHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Tap It DB";
    private static final int DATABASE_VERSION = 1;
    protected static final String TABLE_BEERS = "beers";
    public static final String KEY_ID = "id";
    public static final String BEER_NAME = "name";
    public static final String BEER_RATING = "rating";
    public static final String USER_NAME = "user_name";


    public SQLiteBeerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BEER_TABLE = "CREATE TABLE " + TABLE_BEERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +
                BEER_NAME + " TEXT," + BEER_RATING + " INTEGER," + USER_NAME + " TEXT)";

        db.execSQL(CREATE_BEER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BEERS);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
