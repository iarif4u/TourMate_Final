package com.example.mdarifur.tourmate.Fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.Constant.Constant;
import com.example.mdarifur.tourmate.Database.EventDatabaseSource;
import com.example.mdarifur.tourmate.Is_Valid;
import com.example.mdarifur.tourmate.Model.Event_Contact;
import com.example.mdarifur.tourmate.Preference;
import com.example.mdarifur.tourmate.R;
import com.example.mdarifur.tourmate.TimeAndDate.DateOperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MD.Arifur on 8/24/2016.
 */

public class AddEvent extends Fragment {
    private EventDatabaseSource eventDatabaseSource;
    Preference preference;
    DateOperation dateOperation;

    Is_Valid isValid;
    Button addEventBT;
    TextView eventNameET, toET, startjourneyET, endjourneyET, budgetET;
    String eventName, to, startjourney, endjourney, budget;
    long Stat_timeStamp = 0;
    long end_timeStamp = 0;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_addevent, container, false);
        getInstance(rootView);
        return rootView;
    }

    private void getInstance(View rootView) {
        isValid = new Is_Valid(getActivity());
        dateOperation  = new DateOperation();
        eventDatabaseSource = new EventDatabaseSource(getActivity());
        preference = new Preference(getActivity());
        eventNameET = (TextView) rootView.findViewById(R.id.evetNameET);
        toET = (TextView) rootView.findViewById(R.id.toET);
        startjourneyET = (TextView) rootView.findViewById(R.id.startjourneyET);
        endjourneyET = (TextView) rootView.findViewById(R.id.endjourneyET);
        budgetET = (TextView) rootView.findViewById(R.id.budgetET);
        addEventBT = (Button) rootView.findViewById(R.id.addeventBTN);
        addEventBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInstance();
                if(isValid.CheckEventData(eventName,to,startjourney,endjourney,budget)){
                    String user_id = preference.getUserData(Constant.ID);
                    boolean is_insert = eventDatabaseSource.addContact(new Event_Contact(eventName,to,startjourney,endjourney,budget,user_id));
                   // Toast.makeText(getActivity(), String.valueOf(is_insert), Toast.LENGTH_SHORT).show();
                    if(is_insert==true){
                        hideSoftKeyboard(getActivity());
                        Toast.makeText(getActivity(), "Tour Event Add Successfully:", Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.content_Frame, new EventList()).commit();
                    }else{
                        Toast.makeText(getActivity(), "Fail to add event", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        startjourneyET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateOperation.SetUpDatePicker();
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        String startJourney = String.valueOf(i2) + "-" + String.valueOf(i1 + 1) + "-" + String.valueOf(i);
                        Stat_timeStamp = dateOperation.getTimestamp(startJourney);
                        long CurrenttimeSpamp = dateOperation.getTimestamp(dateOperation.getCurrentDate());
                        if (CurrenttimeSpamp <= Stat_timeStamp) {
                            startjourneyET.setText(startJourney);
                        } else {
                            Toast.makeText(getActivity(), "You can't select any previous day", Toast.LENGTH_LONG).show();
                            startjourneyET.setText("");
                        }
                    }
                }, dateOperation.getYear(), dateOperation.getMonth(), dateOperation.getDay());
                datePicker.setTitle("Select Date");
                datePicker.show();
            }
        });

        endjourneyET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Stat_timeStamp == 0) {
                    Toast.makeText(getActivity(), "First Select your Start journey date", Toast.LENGTH_LONG).show();
                } else {
                    dateOperation.SetUpDatePicker();
                    DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            String endJourney = String.valueOf(i2) + "-" + String.valueOf(i1 + 1) + "-" + String.valueOf(i);
                            end_timeStamp = dateOperation.getTimestamp(endJourney);
                            if (Stat_timeStamp <= end_timeStamp) {
                                endjourneyET.setText(endJourney);
                            } else {
                                Toast.makeText(getActivity(), "You can't select the day", Toast.LENGTH_LONG).show();
                                endjourneyET.setText("");
                            }
                        }
                    }, dateOperation.getYear(), dateOperation.getMonth(), dateOperation.getDay());
                    datePicker.setTitle("Select Date");
                    datePicker.show();
                }
            }
        });
    }

    private void setInstance() {
        eventName = eventNameET.getText().toString();
        to = toET.getText().toString();
        startjourney = startjourneyET.getText().toString();
        endjourney = endjourneyET.getText().toString();
        budget = budgetET.getText().toString();
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
