package com.example.mdarifur.tourmate;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by MD.Arifur on 8/19/2016.
 */
public class Is_Valid {
    private Context context;
    private boolean returnValue = true;
    private String setInfo="";
    public Is_Valid(Context context) {
        this.context = context;
    }
    private int getLength(String data){
        String dataLength = data.replaceAll("\\s+"," ");
            return dataLength.length();
    }
    private boolean ValidMail(String email) {
        String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailregex);
    }

    public boolean CheckEventData(String eventName,String to, String startJourney, String stopJourney,String budget){

        String message = "";
        boolean returnValue=false;
        if (getLength(eventName)<3){
            returnValue = false;
            message = message+"Event Name ";
        }if (getLength(to)<3){
            returnValue = false;
            message = message+"To ";
        }if (getLength(startJourney)<3){
            returnValue = false;
            message = message+"Start Journey Date ";
        }if (getLength(stopJourney)<3){
            returnValue = false;
            message = message+"End Journey Date ";
        }if(getLength(stopJourney)<3){
            returnValue = false;
            message = message+"Budget ";
        }
        if(getLength(message)>4){
            Toast.makeText(context, message+"is not valid", Toast.LENGTH_LONG).show();
            setInfo = "";
        }else{
            returnValue = true;
        }

        return returnValue;
    }


    public boolean CheckData(String userName, String password, String email, String phone) {
        if (getLength(userName)<4){
            returnValue = false;
            setInfo = setInfo+"Username ";
        }
        if (ValidMail(email)==false){
            returnValue = false;
            setInfo = setInfo+"Emil ";
        }
        if (getLength(password)<5){
            returnValue = false;
            setInfo = setInfo+"Password ";
        }if (getLength(phone)<10){
            returnValue = false;
            setInfo = setInfo+"Phone Number ";
        }
        if(getLength(setInfo)>4){
            Toast.makeText(context, setInfo+"is not valid", Toast.LENGTH_LONG).show();
            setInfo = "";
        }else{
            returnValue = true;
        }

        return returnValue;
    }

}
