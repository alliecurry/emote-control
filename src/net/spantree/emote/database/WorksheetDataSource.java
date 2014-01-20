package net.spantree.emote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import net.spantree.emote.domain.Emotion;
import net.spantree.emote.domain.Question;
import net.spantree.emote.domain.Worksheet;

import java.sql.SQLException;
import java.util.*;

public class WorksheetDataSource {
    private static final String TAG = "WorksheetDataSource";
    private SQLiteDatabase database;
    private EmoteSQLiteHelper dbHelper;
    private String[] allColumns = {EmoteSQLiteHelper.COLUMN_ID,
            EmoteSQLiteHelper.COLUMN_DATE,
            EmoteSQLiteHelper.COLUMN_EMOTION,
            EmoteSQLiteHelper.COLUMN_QUESTION_A,
            EmoteSQLiteHelper.COLUMN_QUESTION_B,
            EmoteSQLiteHelper.COLUMN_QUESTION_C,
            EmoteSQLiteHelper.COLUMN_QUESTION_D,
            EmoteSQLiteHelper.COLUMN_QUESTION_E,
    };

    public WorksheetDataSource(Context context) {
        dbHelper = new EmoteSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Worksheet saveWorksheet(Worksheet worksheet) {
        ContentValues values = serializeWorksheet(worksheet);

        long insertId = database.insert(EmoteSQLiteHelper.TABLE_WORKSHEETS, null, values);
        Cursor cursor = database.query(EmoteSQLiteHelper.TABLE_WORKSHEETS, allColumns,
                EmoteSQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Worksheet newWorksheet = cursorToWorksheet(cursor);
        cursor.close();
        return newWorksheet;
    }

    public void deleteWorksheet(Worksheet worksheet) {
        long id = worksheet.getId();
        database.delete(EmoteSQLiteHelper.TABLE_WORKSHEETS, EmoteSQLiteHelper.COLUMN_ID
                + " = " + id, null);
        Log.i(TAG, "Worksheet with id: " + id + " deleted");
    }

    public List<Worksheet> getAllWorksheets() {
        List<Worksheet> worksheets = new ArrayList<Worksheet>();

        Cursor cursor = database.query(EmoteSQLiteHelper.TABLE_WORKSHEETS, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Worksheet worksheet = cursorToWorksheet(cursor);
            worksheets.add(worksheet);
            cursor.moveToNext();
        }
        return worksheets;
    }

    private Worksheet cursorToWorksheet(Cursor cursor) {
        Worksheet worksheet = new Worksheet();
        worksheet.setId(cursor.getLong(0));
        worksheet.setDateCreated(new Date(cursor.getInt(1)));
        worksheet.setEmotion(Emotion.valueOf(cursor.getString(2)));

        Map<Question, String> responseMap = new HashMap<Question, String>();
        responseMap.put(Question.QUESTION_A, cursor.getString(3));
        responseMap.put(Question.QUESTION_B, cursor.getString(4));
        responseMap.put(Question.QUESTION_C, cursor.getString(5));
        responseMap.put(Question.QUESTION_D, cursor.getString(6));
        responseMap.put(Question.QUESTION_E, cursor.getString(7));

        worksheet.setQuestionResponses(responseMap);

        return worksheet;
    }

    private ContentValues serializeWorksheet(Worksheet worksheet) {
        ContentValues values = new ContentValues();
        values.put(EmoteSQLiteHelper.COLUMN_DATE, worksheet.getDateCreated().getTime());
        values.put(EmoteSQLiteHelper.COLUMN_EMOTION, worksheet.getEmotion().toString());
        values.put(EmoteSQLiteHelper.COLUMN_QUESTION_A, worksheet.getQuestionResponses().get(Question.QUESTION_A));
        values.put(EmoteSQLiteHelper.COLUMN_QUESTION_B, worksheet.getQuestionResponses().get(Question.QUESTION_B));
        values.put(EmoteSQLiteHelper.COLUMN_QUESTION_C, worksheet.getQuestionResponses().get(Question.QUESTION_C));
        values.put(EmoteSQLiteHelper.COLUMN_QUESTION_D, worksheet.getQuestionResponses().get(Question.QUESTION_D));
        values.put(EmoteSQLiteHelper.COLUMN_QUESTION_E, worksheet.getQuestionResponses().get(Question.QUESTION_E));

        return values;
    }

}
