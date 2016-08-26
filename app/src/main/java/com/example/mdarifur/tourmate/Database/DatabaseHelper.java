package com.example.mdarifur.tourmate.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 8/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "contact_manager";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_CONTACT = "contact_info";
    static final String TABLE_EVENT = "event_Info";
    static final String TABLE_PHOTO_DATA = "photo_data";
    static final String TABLE_BUDGET = "budget";

    static final String budget_id = "id";
    static final String budget_cost = "cost";
    static final String budget_EventID = "eventid";

    static final String clint_id = "id";
    static final String clint_name = "name";
    static final String clint_password = "password";
    static final String clint_photo = "photo";
    static final String clint_phoneNub = "PhoneNub";
    static final String clint_emailId = "emailId";
    static final String clint_emerzencyPhnoeNub = "emerzencyPhnoeNub";

    static final String event_id = "eventid";
    static final String event_name = "event_name";
    static final String to = "to_place";
    static final String start_journey = "startjourney";
    static final String end_journey = "endjourney";
    static final String event_Budget = "budget";
    static final String clintEvent_id = "id";

    static final String photo_id = "id";
    static final String photoName ="photoName";
    static final String caption="caption";
    static final String date="date";
    static final String time="time";
    static final String eventID="eventID";


    public static final String Create_Photo_data = "CREATE TABLE " + TABLE_PHOTO_DATA + "( " + photo_id + " integer PRIMARY KEY, " + photoName + " text, " + caption + " text, " + date + " text, " + time + " text, " + eventID + " text);";


    public static final String Create_Claint_Table = "CREATE TABLE " + TABLE_CONTACT + "( " + clint_id + " integer PRIMARY KEY, " + clint_name + " text, " + clint_password + " text, " + clint_photo + " text, " + clint_phoneNub + " text, " + clint_emerzencyPhnoeNub + " text, " + clint_emailId + " text);";

    public static final String Create_Event_Table = "CREATE TABLE " + TABLE_EVENT + "( " + event_id + " integer PRIMARY KEY, " + event_name + " text, " + to + " text, " + start_journey + " text, " + end_journey + " text, " + event_Budget + " text, " + clintEvent_id + " text);";

    public static final String Create_Budget_Data = "CREATE TABLE " + TABLE_BUDGET + "( " + budget_id + " integer PRIMARY KEY, " + budget_cost + " integer, " + budget_EventID + " text);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_Budget_Data);
        sqLiteDatabase.execSQL(Create_Photo_data);
        sqLiteDatabase.execSQL(Create_Event_Table);
        sqLiteDatabase.execSQL(Create_Claint_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exist" + TABLE_PHOTO_DATA);
        sqLiteDatabase.execSQL("drop table if exist" + TABLE_CONTACT);
        sqLiteDatabase.execSQL("drop table if exist" + TABLE_EVENT);
        sqLiteDatabase.execSQL("drop table if exist" + TABLE_BUDGET);
        onCreate(sqLiteDatabase);
    }
}
