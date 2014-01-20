package net.spantree.emote.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EmoteSQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_WORKSHEETS = "worksheets";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_EMOTION = "emotion";
    public static final String COLUMN_QUESTION_A = "question_a";
    public static final String COLUMN_QUESTION_B = "question_b";
    public static final String COLUMN_QUESTION_C = "question_c";
    public static final String COLUMN_QUESTION_D = "question_d";
    public static final String COLUMN_QUESTION_E = "question_e";

    private static final String DATABASE_NAME = "emotions.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_WORKSHEETS + "(" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_DATE + " integer not null," +
            COLUMN_EMOTION + " text not null," +
            COLUMN_QUESTION_A + " text," +
            COLUMN_QUESTION_B + " text," +
            COLUMN_QUESTION_C + " text," +
            COLUMN_QUESTION_D + " text," +
            COLUMN_QUESTION_E + " text" +
            ");";

    public EmoteSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(EmoteSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKSHEETS);
        onCreate(db);
    }

}
