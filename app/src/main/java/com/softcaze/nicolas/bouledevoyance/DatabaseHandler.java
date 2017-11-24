package com.softcaze.nicolas.bouledevoyance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nicolas on 20/11/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String NOM_TABLE = "prediction";
    public static final String COL_ID = "id";
    public static final int NUM_COL_ID = 0;
    public static final String COL_TEXT = "text";
    public static final int NUM_COL_TEXT = 1;
    public static final String COL_DEJA_LU = "deja_lu";
    public static final int NUM_COL_DEJA_LU = 2;

    public static final String NOM_TABLE_NBR_PREDICT = "nbr_predict";
    public static final String COL_NBR = "nbr";
    public static final int NUM_COL_NBR = 0;
    public static final String COL_DATE_PREDICT = "date_predict";
    public static final int NUM_COL_DATE_PREDICT = 1;

    /***/  			/***/			/***/

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_TEXT + " TEXT, " + COL_DEJA_LU + " INTEGER);";

    public static final String CREATE_TABLE_NBR_PREDICT = "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_NBR_PREDICT + " (" +
                    COL_NBR + " INTEGER, " +
                    COL_DATE_PREDICT + " DATE);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOM_TABLE + ";";

    public static final String DROP_TABLE_NBR_PREDICT = "DROP TABLE IF EXISTS " + NOM_TABLE_NBR_PREDICT + ";";

    public DatabaseHandler(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_NBR_PREDICT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO Auto-generated method stub
        db.execSQL(DROP_TABLE);
        db.execSQL(DROP_TABLE_NBR_PREDICT);
        onCreate(db);
    }
}
