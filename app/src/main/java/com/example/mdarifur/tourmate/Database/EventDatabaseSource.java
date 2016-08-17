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
        contentValues.put(DatabaseHelper.event_name,event_contact.getEventname());
        contentValues.put(DatabaseHelper.event_name,event_contact.getEventname());
        contentValues.put(DatabaseHelper.event_name,event_contact.getEventname());




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

        Cursor cursor=database.query(DatabaseHelper.TABLE_CONTACT,new String[]{DatabaseHelper.clint_id,DatabaseHelper.clint_name,
                DatabaseHelper.clint_password,DatabaseHelper.clint_photo,DatabaseHelper.clint_phoneNub},DatabaseHelper.clint_id+" = "+id,null,null,null,null);

        cursor.moveToFirst();
        int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.clint_id));
        String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_name));
        String mPhone=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_password));
        String mPhoto=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_photo));
        String mPhoneNuub=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_phoneNub));

        cursor.close();
        contact=new Contact(mId,mName,mPhone,mPhoto,mPhoneNuub);
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
                int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.clint_id));
                String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_name));
                String mPassword=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_password));
                String mPhoto=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_photo));
                String mPhoneNub=cursor.getString(cursor.getColumnIndex(DatabaseHelper.clint_phoneNub));

                contact=new Contact(mId,mName,mPassword,mPhoto,mPhoneNub);
                contacts.add(contact);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return contacts;
    }

    public boolean updateContact(int id,Contact contact){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.clint_name,contact.getName());
        contentValues.put(DatabaseHelper.clint_password,contact.getPassword());
        contentValues.put(DatabaseHelper.clint_password,contact.getPhoto());
        contentValues.put(DatabaseHelper.clint_password,contact.getPhoneNub());
        int update=database.update(DatabaseHelper.TABLE_CONTACT,contentValues,DatabaseHelper.clint_id+" = "+id,null);
        this.close();

        if(update>0){
            return true;

        }else {
            return false;
        }

    }

    public boolean deleteContact(int id){
        this.open();

        int deleted=database.delete(DatabaseHelper.TABLE_CONTACT, DatabaseHelper.clint_id + " = " + id, null);

        this.close();

        if(deleted>0){
            return true;
        }else{
            return false;
        }
    }

}
