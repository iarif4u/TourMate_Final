package com.example.mdarifur.tourmate.TimeAndDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MD.Arifur on 8/25/2016.
 */
public class DateOperation {
    private Calendar c;
    private int year, month, day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getCurrentTime(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        return df.format(c.getTime());
    }

    public String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(c.getTime());
    }

    public long getTimestamp(String str_date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public void SetUpDatePicker() {
        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }

}
