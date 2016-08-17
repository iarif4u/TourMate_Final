package com.example.mdarifur.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.mdarifur.tourmate.Model.Contact;
import com.example.mdarifur.tourmate.Model.Event_Contact;

import java.util.ArrayList;

/**
 * Created by hp on 8/14/2016.
 */
public class EventDatabaseSource {




    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Contact contact;

    public EventDatabaseSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }


    public boolean addContact(Event_Contact event_contact){
        this.open();


        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.event_name,event_contact.getEventname());
        contentValues.put(DatabaseHelper.from,event_contact.getFrom());
        contentValues.put(DatabaseHelper.to,event_contact.getTo());
        contentValues.put(DatabaseHelper.start_journey,event_contact.getStartJourney());
        contentValues.put(DatabaseHelper.end_journey,event_contact.getEndjourney());
        contentValues.put(DatabaseHelper.event_Timeline,event_contact.getEventtimeline());
        contentValues.put(DatabaseHelper.event_Budget,event_contact.getEventbudget());
        contentValues.put(DatabaseHelper.clintEvent_id,event_contact.getClinteventId());


        long inserted=database.insert(DatabaseHelper.TABLE_CONTACT,null,contentValues);
        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }
    }



    public Contact getContact(int id){
        this.open();

        //nicher line ta dakhen    clint_id r por (+) diye clintEvent_id likchi aita ki hoyeche kina????????


        Cursor cursor=database.query(DatabaseHelper.TABLE_CONTACT, new String[]{DatabaseHelper.event_id, DatabaseHelper.event_name,
                DatabaseHelper.from, DatabaseHelper.to, DatabaseHelper.start_journey, DatabaseHelper.end_journey, DatabaseHelper.event_Timeline,
                DatabaseHelper.event_Budget}, DatabaseHelper.clint_id + DatabaseHelper.clintEvent_id +" = " + id, null, null, null, null);

        cursor.moveToFirst();
        int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.event_id));
        String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_name));
        String mForm=cursor.getString(cursor.getColumnIndex(DatabaseHelper.from));
        String mTo=cursor.getString(cursor.getColumnIndex(DatabaseHelper.to));
        String mStartJourney=cursor.getString(cursor.getColumnIndex(DatabaseHelper.start_journey));
        String mEndJourney=cursor.getString(cursor.getColumnIndex(DatabaseHelper.end_journey));
        String mEventTimeline=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_Timeline));
        String mEvent_budget=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_Budget));
        int mClint_event_id=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.clintEvent_id));

        cursor.close();
       // contact=new Contact(mId,mClint_event_id,mName,mForm,mTo,mStartJourney,mEndJourney,mEventTimeline,mEvent_budget);
        this.close();
        return contact;
    }

    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact>contacts=new ArrayList<>();
        this.open();
        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_CONTACT,null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();

            for(int i=0;i<cursor.getCount();i++){
                int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.event_id));
                String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_name));
                String mForm=cursor.getString(cursor.getColumnIndex(DatabaseHelper.from));
                String mTo=cursor.getString(cursor.getColumnIndex(DatabaseHelper.to));
                String mStartJourney=cursor.getString(cursor.getColumnIndex(DatabaseHelper.start_journey));
                String mEndJourney=cursor.getString(cursor.getColumnIndex(DatabaseHelper.end_journey));
                String mEventTimeline=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_Timeline));
                String mEvent_budget=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_Budget));
                int mClint_event_id=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.clintEvent_id));


                //contact=new Contact(mId,mClint_event_id,mName,mForm,mTo,mStartJourney,mEndJourney,mEventTimeline,mEvent_budget);
                contacts.add(contact);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return contacts;
    }

    public boolean updateContact(int id,Event_Contact event_contact){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.event_name,event_contact.getEventname());
        contentValues.put(DatabaseHelper.from,event_contact.getFrom());
        contentValues.put(DatabaseHelper.to,event_contact.getTo());
        contentValues.put(DatabaseHelper.start_journey,event_contact.getStartJourney());
        contentValues.put(DatabaseHelper.end_journey,event_contact.getEndjourney());
        contentValues.put(DatabaseHelper.event_Timeline,event_contact.getEventtimeline());
        contentValues.put(DatabaseHelper.event_Budget,event_contact.getEventbudget());



        //nicher line ta dakhen    clint_id r por (+) diye clintEvent_id likchi aita ki hoyeche kina????????

        int update=database.update(DatabaseHelper.TABLE_CONTACT,contentValues,DatabaseHelper.clint_id +
                DatabaseHelper.clintEvent_id+" = "+id,null);
        this.close();

        if(update>0){
            return true;

        }else {
            return false;
        }

    }

    public boolean deleteContact(int id){
        this.open();

        //Akhaneo same obostha check koren

        int deleted=database.delete(DatabaseHelper.TABLE_CONTACT, DatabaseHelper.clint_id +DatabaseHelper.clintEvent_id +
                " = " + id, null);

        this.close();

        if(deleted>0){
            return true;
        }else{
            return false;
        }
    }


}
