package com.example.mdarifur.tourmate.Model;

/**
 * Created by MD.Arifur on 8/26/2016.
 */
public class Budget {
    int id;
    String cost,eventID;

    public Budget() {
    }

    public Budget(String cost, String eventID) {
        this.cost = cost;
        this.eventID = eventID;
    }

    public Budget(int id, String cost, String eventID) {
        this.id = id;
        this.cost = cost;
        this.eventID = eventID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
}
