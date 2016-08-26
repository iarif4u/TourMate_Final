package com.example.mdarifur.tourmate.Model;

/**
 * Created by MD.Arifur on 8/26/2016.
 */
public class PhotoData {
    int id;
    String photoName;
    String caption;
    String date;
    String time;
    String eventID;

    public PhotoData() {
    }

    public PhotoData(String photoName,String caption , String time, String date, String eventID) {
        this.eventID = eventID;
        this.time = time;
        this.date = date;
        this.caption = caption;
        this.photoName = photoName;
    }

    public PhotoData(int id, String photoName, String caption, String date, String time, String eventID) {
        this.id = id;
        this.photoName = photoName;
        this.caption = caption;
        this.date = date;
        this.time = time;
        this.eventID = eventID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
}
