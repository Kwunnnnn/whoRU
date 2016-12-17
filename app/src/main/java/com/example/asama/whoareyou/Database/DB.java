package com.example.asama.whoareyou.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asama on 12/17/2016.
 */

public class DB extends SQLiteOpenHelper {

    private static final String DB_NAME = "DB4.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_PICTURE_NAME = "Picture";
    public static final String COL_PICTURE_ID = "_id";
    public static final String COL_PICTURE_RESULT = "nameResult";
    public static final String COL_PICTURE_NAMEFILE = "nameFile";

    public DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreatePictureTable = "CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT," +
                "%s TEXT)";
        sqlCreatePictureTable = String.format(sqlCreatePictureTable, TABLE_PICTURE_NAME, COL_PICTURE_ID, COL_PICTURE_RESULT, COL_PICTURE_NAMEFILE);
        db.execSQL(sqlCreatePictureTable);

        ContentValues cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "a.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "โคลบี้ ไบรอัน");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "b.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "สตีเว่น  เจอร์ราด");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "c.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "อองตวน กรีซมันน์");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "d.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "ลิโอเนล เมสซี่");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "e.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "รอนนี่ โอซุลลิแวน");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "f.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "ศุภวุฒิ เถื่อนกลาง");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "g.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "โชติกา  วงศ์วิลาศ");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "h.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "คริส  แฮมเวิร์ธ");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "i.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "พอล วอล์คเกอร์");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(DB.COL_PICTURE_NAMEFILE, "j.jpg");
        cv.put(DB.COL_PICTURE_RESULT, "ทอม  ครูซ");
        db.insert(DB.TABLE_PICTURE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
