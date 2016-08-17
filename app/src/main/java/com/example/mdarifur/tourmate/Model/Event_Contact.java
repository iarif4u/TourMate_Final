package com.example.mdarifur.tourmate.Model;

/**
 * Created by hp on 8/14/2016.
 */
public class Event_Contact {

    private int eventid;
    private String eventname;
    private String from;
    private String to;
    private String startJourney;
    private String endjourney;
    private String eventtimeline;
    private String eventbudget;
    private String clinteventId;


    public Event_Contact() {
    }

    public Event_Contact(int eventid, String eventname, String from, String to, String startJourney, String endjourney, String eventtimeline, String eventbudget, String clinteventId) {
        this.eventid = eventid;
        this.eventname = eventname;
        this.from = from;
        this.to = to;
        this.startJourney = startJourney;
        this.endjourney = endjourney;
        this.eventtimeline = eventtimeline;
        this.eventbudget = eventbudget;
        this.clinteventId = clinteventId;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {

        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStartJourney() {
        return startJourney;
    }

    public void setStartJourney(String startJourney) {
        this.startJourney = startJourney;
    }

    public String getEndjourney() {
        return endjourney;
    }

    public void setEndjourney(String endjourney) {
        this.endjourney = endjourney;
    }

    public String getEventtimeline() {
        return eventtimeline;
    }

    public void setEventtimeline(String eventtimeline) {
        this.eventtimeline = eventtimeline;
    }

    public String getClinteventId() {
        return clinteventId;
    }

    public void setClinteventId(String clinteventId) {
        this.clinteventId = clinteventId;
    }

    public String getEventbudget() {
        return eventbudget;
    }

    public void setEventbudget(String eventbudget) {
        this.eventbudget = eventbudget;
    }





}
