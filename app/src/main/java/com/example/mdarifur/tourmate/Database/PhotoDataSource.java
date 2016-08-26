package com.example.mdarifur.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mdarifur.tourmate.Model.Contact;
import com.example.mdarifur.tourmate.Model.Event_Contact;
import com.example.mdarifur.tourmate.Model.PhotoData;

import java.util.ArrayList;

/**
 * Created by MD.Arifur on 8/26/2016.
 */
public class PhotoDataSource {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private PhotoData photoData;

    public PhotoDataSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }


    public boolean addPhotoData(PhotoData photoData){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.photoName,photoData.getPhotoName());
        contentValues.put(DatabaseHelper.caption,photoData.getCaption());
        contentValues.put(DatabaseHelper.date,photoData.getDate());
        contentValues.put(DatabaseHelper.time,photoData.getTime());
        contentValues.put(DatabaseHelper.eventID,photoData.getEventID());

        long inserted=database.insert(DatabaseHelper.TABLE_PHOTO_DATA,null,contentValues);
        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<PhotoData> getTimeLine(String id){

        ArrayList<PhotoData>timeLine=new ArrayList<>();
        this.open();
        Cursor cursor=database.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_PHOTO_DATA+" WHERE "+DatabaseHelper.event_id+" = ?", new String[]{id});

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
                int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.photo_id));
                String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.photoName));
                String mCaption=cursor.getString(cursor.getColumnIndex(DatabaseHelper.caption));
                String mDate=cursor.getString(cursor.getColumnIndex(DatabaseHelper.date));
                String mtime=cursor.getString(cursor.getColumnIndex(DatabaseHelper.time));
               // String mEvent_id=cursor.getString(cursor.getColumnIndex(DatabaseHelper.event_id));
                photoData=new PhotoData(mId, mName, mCaption, mDate,mtime,"1");
                timeLine.add(photoData);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return timeLine;
    }
}
