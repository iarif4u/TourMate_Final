package com.example.mdarifur.tourmate.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 8/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    static final String DATABASE_NAME="contact_manager";
    static final int DATABASE_VERSION=1;
    static final String TABLE_CONTACT="contact_info";

    static final String clint_id ="id";
    static final String clint_name ="name";
    static final String clint_password ="password";
    static final String clint_photo ="photo";
    static final String clint_phoneNub ="PhoneNub";
    static final String clint_emailId ="emailId";

    static final String event_id ="eventid";
    static final String event_name ="event_name";
    static final String from ="from";
    static final String to ="to";
    static final String start_journey ="startjourney";
    static final String end_journey ="endjourney";
    static final String event_Timeline ="timeline";
    static final String event_Budget ="budget";
    static final String clintEvent_id="id";



    static final String Create_Claint_Table="create table "+TABLE_CONTACT+"( "+clint_id+"Primary key "+clint_name+"text "+clint_password+"text "+clint_photo+"text "
            +clint_phoneNub+"text"+clint_emailId+"text);";



    static final String Create_Event_Table="create event table "+TABLE_CONTACT+"( "+event_id+"primary key "+event_name+"text "+from+"text "
            +to+"text "+start_journey+"text "+end_journey+"text "+event_Timeline+"text " +clintEvent_id+"Secondary key "+event_Budget+"text);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Create_Claint_Table);
        sqLiteDatabase.execSQL(Create_Event_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exist"+TABLE_CONTACT);
        onCreate(sqLiteDatabase);
    }
}
