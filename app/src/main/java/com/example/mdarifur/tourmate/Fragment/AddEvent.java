package com.example.mdarifur.tourmate.Fragment;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdarifur.tourmate.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MD.Arifur on 8/24/2016.
 */
@TargetApi(Build.VERSION_CODES.N)
public class AddEvent extends Fragment {
    Calendar c;
    int year,month,day;
    Button addEventBT;
    TextView eventNameET,toET,startjourneyET,endjourneyET,budgetET;
    String eventName,to,startjourney,endjourney,budget;
    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_addevent, container, false);
        getInstance(rootView);
        return rootView;
    }
    private void getInstance(View rootView){
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
                Toast.makeText(getActivity(), eventName+" "+to, Toast.LENGTH_LONG).show();
            }
        });

        startjourneyET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetUpDatePicker();
                DatePickerDialog datePicker =new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        String start = String.valueOf(i2)+"-"+String.valueOf(i1+1)+"-"+String.valueOf(i);
                        long SelecttimeSpamp =getTimestamp(start);
                        long CurrenttimeSpamp =getTimestamp(getCurrentDate());
                        String res ="";
                        if(CurrenttimeSpamp<=SelecttimeSpamp){
                            startjourneyET.setText(start);
                        }else{
                            Toast.makeText(getActivity(),"You can't select any previous day", Toast.LENGTH_LONG).show();
                            startjourneyET.setText("");
                        }
                    }
                },year,month,day);
                datePicker.setTitle("Select Date");
                datePicker.show();
            }
        });
    }

    private void SetUpDatePicker(){
        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }

    private void setInstance(){
        eventName = eventNameET.getText().toString();
        to = toET.getText().toString();
        startjourney = startjourneyET.getText().toString();
        endjourney = endjourneyET.getText().toString();
        budget = budgetET.getText().toString();
    }
    public String getCurrentDate(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(c.getTime());
    }
    public long getTimestamp(String str_date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = (Date)formatter.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
